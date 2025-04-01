package com.example.laboratorio.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laboratorio.data.ProductoEntity;
import com.example.laboratorio.dto.response.ResponseEstadoSierraDTO;
import com.example.laboratorio.repository.ProductoRepository;
import com.example.laboratorio.services.interfaces.SierraService;

import java.util.List;

@Service
public class SierraServiceImpl implements SierraService {

    @Autowired
    private ProductoRepository productoRepository;
    
    @Override
    public ResponseEstadoSierraDTO obtenerEstadoSierra() {
        // Buscamos productos de tipo "sierra"
        List<ProductoEntity> sierraList = productoRepository.findByTipo("sierra");
        ResponseEstadoSierraDTO response = new ResponseEstadoSierraDTO();
        
        if(!sierraList.isEmpty()){
            // Para este ejemplo, devolvemos el primer producto encontrado
            ProductoEntity sierra = sierraList.get(0);
            response.setIdProducto(sierra.getIdProducto());
            response.setDescripcion(sierra.getDescripcion());
            response.setEstado(sierra.getEstado());
        } else {
            response.setDescripcion("No se encontró ninguna sierra");
            response.setEstado("Sin datos");
        }
        return response;
    }
}
