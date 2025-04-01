package com.example.laboratorio.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laboratorio.data.InventarioEntity;
import com.example.laboratorio.dto.response.ResponseInventarioProduccionDTO;
import com.example.laboratorio.dto.response.ResponseProductoProduccionDTO;
import com.example.laboratorio.repository.InventarioProduccionRepository;
import com.example.laboratorio.services.interfaces.IInventarioProduccionServices;


@Service
public class InventarioProduccionServices implements IInventarioProduccionServices {

    @Autowired
    private InventarioProduccionRepository inventarioProduccionRepository;

    @Override
    public ResponseInventarioProduccionDTO getInventarioProduccion() {

        ResponseInventarioProduccionDTO inventarioProduccionDTO = new ResponseInventarioProduccionDTO();
        List<ResponseProductoProduccionDTO> listProductos = new ArrayList<>();

        List<InventarioEntity> listInventarioProduccion = inventarioProduccionRepository.findAll();

        for(InventarioEntity inventarioProduccionEntity : listInventarioProduccion) {

            ResponseProductoProduccionDTO productoProduccionDTO = new ResponseProductoProduccionDTO();

            productoProduccionDTO.setCantidad(inventarioProduccionEntity.getCantidad());
            productoProduccionDTO.setEstado(inventarioProduccionEntity.getEstado());
            productoProduccionDTO.setIdProducto(inventarioProduccionEntity.getProducto().getIdProducto());
            listProductos.add(productoProduccionDTO);
        }

        inventarioProduccionDTO.setProductos(listProductos);

        return inventarioProduccionDTO;
    }

}
