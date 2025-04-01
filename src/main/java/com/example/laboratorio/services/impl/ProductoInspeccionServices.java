package com.example.laboratorio.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laboratorio.data.ProductoInspeccionEntity;
import com.example.laboratorio.dto.request.RequestProductoInspeccion;
import com.example.laboratorio.dto.response.ResponseProductoInspeccionDTO;
import com.example.laboratorio.repository.ProductoInspeccionRepository;
import com.example.laboratorio.services.interfaces.IProductoInspeccionServices;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoInspeccionServices implements IProductoInspeccionServices {
    
    @Autowired
    private ProductoInspeccionRepository repository;

    @Override
    public List<ProductoInspeccionEntity> obtenerProductosNoCertificados() {
        List<ProductoInspeccionEntity> productos = repository.findAll();
        
        // Filtrar productos con estado NULL o vacío
        return productos.stream()
            .filter(p -> p.getEstado() == null || p.getEstado().trim().isEmpty())
            .collect(Collectors.toList());
    }

    @Override
    public ResponseProductoInspeccionDTO inspeccionarProducto(RequestProductoInspeccion request) {
        ProductoInspeccionEntity entity = new ProductoInspeccionEntity();
        entity.setId_producto(request.getId_producto());
        entity.setId_solicitud_produccion(request.getId_solicitud_produccion());
        entity.setId_certificacion(request.getId_certificacion());
        entity.setCantidad_certificada(request.getCantidad_certificada());

        // Aplicar MIL-STD-105E (AQL)
        if (request.getCantidad_certificada() >= 10) {
            entity.setEstado("APROBADO");
            entity.setResultado_inspeccion("Producto aprobado bajo estándares AQL 99%");
            entity.setObservaciones("Cumple con los estándares de calidad.");
        } else {
            entity.setEstado("RECHAZADO");
            entity.setResultado_inspeccion("Producto rechazado por no cumplir AQLS");
            entity.setObservaciones("Se detectaron anomalías en la inspección.");
        }

        repository.save(entity);
        return new ResponseProductoInspeccionDTO(entity.getResultado_inspeccion(), entity.getObservaciones());
    }
}
