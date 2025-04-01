package com.example.laboratorio.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laboratorio.data.DetalleSolicitudEntity;
import com.example.laboratorio.data.InventarioEntity;
import com.example.laboratorio.data.SolicitudProduccionEntity;
import com.example.laboratorio.dto.request.RequestProduccionDTO;
import com.example.laboratorio.dto.response.ResponseInventarioProduccionDTO;
import com.example.laboratorio.dto.response.ResponseProduccionDTO;
import com.example.laboratorio.dto.response.ResponseProductoProduccionDTO;
import com.example.laboratorio.repository.DetalleSolicitudRepository;
import com.example.laboratorio.repository.InventarioProduccionRepository;
import com.example.laboratorio.repository.SolicitudProduccionRepository;
import com.example.laboratorio.services.interfaces.IProduccionServices;

@Service
public class ProduccionServices implements IProduccionServices {
    
    @Autowired
    private InventarioProduccionRepository inventarioProduccionRepository;

    @Autowired
    private SolicitudProduccionRepository solicitudProduccionRepository;

    @Autowired
    private DetalleSolicitudRepository detalleSolicitudRepository;

    public ResponseInventarioProduccionDTO getProduccion() {

        ResponseInventarioProduccionDTO response = new ResponseInventarioProduccionDTO();

        List<ResponseProductoProduccionDTO> listResponseProductoProduccionDTO = new ArrayList<>();

        this.inventarioProduccionRepository.findAll().forEach(inventarioEntity -> {
            
            ResponseProductoProduccionDTO responseProductoProduccionDTO = new ResponseProductoProduccionDTO();
            responseProductoProduccionDTO.setIdProducto(inventarioEntity.getProducto().getIdProducto());
            responseProductoProduccionDTO.setCantidad(inventarioEntity.getCantidad());
            responseProductoProduccionDTO.setEstado(inventarioEntity.getEstado());

            listResponseProductoProduccionDTO.add(responseProductoProduccionDTO);
        });

        response.setProductos(listResponseProductoProduccionDTO);

        return response;
    }

    @Override
    public ResponseProduccionDTO crearProduccion(RequestProduccionDTO requestProduccionDTO) {
        
        ResponseProduccionDTO response = new ResponseProduccionDTO();

        List<SolicitudProduccionEntity> listSolicitudProduccionEntity = this.solicitudProduccionRepository.findByFechaSolicitudBefore(new Timestamp(System.currentTimeMillis()));

        for(SolicitudProduccionEntity solicitudProduccionEntity : listSolicitudProduccionEntity) {
           
            List<DetalleSolicitudEntity> listDetalleSolicitudEntity = this.detalleSolicitudRepository.findByDetalleSolicitudPkIdSolicitudProduccion(solicitudProduccionEntity.getIdSolicitudProduccion());

            for(DetalleSolicitudEntity detalleSolicitudEntity : listDetalleSolicitudEntity) {
                InventarioEntity inventarioEntity = new InventarioEntity();
                inventarioEntity.setCantidad(detalleSolicitudEntity.getCantidad());
                inventarioEntity.setEstado("Activo");
                inventarioEntity.setProducto(detalleSolicitudEntity.getProducto());
                this.inventarioProduccionRepository.save(inventarioEntity);
            }

        }

        response.setMensaje("Produccion creada correctamente");

        return response;
    }

}
