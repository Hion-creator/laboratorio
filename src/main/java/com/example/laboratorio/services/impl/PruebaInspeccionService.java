package com.example.laboratorio.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laboratorio.data.PruebaInspeccionEntity;
import com.example.laboratorio.dto.request.RequestPruebaInspeccion;
import com.example.laboratorio.dto.response.ResponsePruebaInspeccionDTO;
import com.example.laboratorio.repository.PruebaInspeccionRepository;
import com.example.laboratorio.services.interfaces.IPruebaInspeccionServices;


@Service
public class PruebaInspeccionService implements IPruebaInspeccionServices {

    @Autowired
    private PruebaInspeccionRepository repository;

    @Override
    public ResponsePruebaInspeccionDTO registrar(RequestPruebaInspeccion request) {
        PruebaInspeccionEntity prueba = new PruebaInspeccionEntity(request);
        PruebaInspeccionEntity savedEntity = repository.save(prueba);
        return new ResponsePruebaInspeccionDTO(savedEntity);
    }

    @Override
    public ResponsePruebaInspeccionDTO obtener(int id) {
        return repository.findById(id)
                .map(ResponsePruebaInspeccionDTO::new)
                .orElseThrow(() -> new RuntimeException("PruebaInspección no encontrada con ID: " + id));
    }
}
