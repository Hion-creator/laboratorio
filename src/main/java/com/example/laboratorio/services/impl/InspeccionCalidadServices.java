package com.example.laboratorio.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laboratorio.data.InspeccionCalidadEntity;
import com.example.laboratorio.dto.request.RequestInspeccionCalidad;
import com.example.laboratorio.dto.response.ResponseInspeccionCalidadDTO;
import com.example.laboratorio.repository.InspeccionCalidadRepository;
import com.example.laboratorio.services.interfaces.IInspeccionCalidadService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InspeccionCalidadServices implements IInspeccionCalidadService {

    @Autowired
    private InspeccionCalidadRepository repository;

    @Override
    public ResponseInspeccionCalidadDTO registrar(RequestInspeccionCalidad request) {
        InspeccionCalidadEntity inspeccion = new InspeccionCalidadEntity();
        inspeccion.setIdProducto(request.getIdProducto());
        inspeccion.setIdSolicitudProduccion(request.getIdSolicitudProduccion());
        inspeccion.setIdCertificacion(request.getIdCertificacion());
        inspeccion.setResultadoInspeccion(request.getResultadoInspeccion());
        inspeccion.setMetodoMuestreo(request.getMetodoMuestreo());
        inspeccion.setObservaciones(request.getObservaciones());
        inspeccion.setFechaInspeccion(LocalDateTime.now());  // Se registra la fecha actual

        InspeccionCalidadEntity savedEntity = repository.save(inspeccion);

        return new ResponseInspeccionCalidadDTO(
                savedEntity.getIdInspeccion(),
                savedEntity.getIdProducto(),
                savedEntity.getIdSolicitudProduccion(),
                savedEntity.getIdCertificacion(),
                savedEntity.getResultadoInspeccion(),
                savedEntity.getMetodoMuestreo(),
                savedEntity.getObservaciones(),
                savedEntity.getFechaInspeccion()
        );
    }

    @Override
    public ResponseInspeccionCalidadDTO obtener(int id) {
        return repository.findById(id)
                .map(inspeccion -> new ResponseInspeccionCalidadDTO(
                        inspeccion.getIdInspeccion(),
                        inspeccion.getIdProducto(),
                        inspeccion.getIdSolicitudProduccion(),
                        inspeccion.getIdCertificacion(),
                        inspeccion.getResultadoInspeccion(),
                        inspeccion.getMetodoMuestreo(),
                        inspeccion.getObservaciones(),
                        inspeccion.getFechaInspeccion()))
                .orElse(null);
    }

    @Override
    public List<ResponseInspeccionCalidadDTO> obtenerTodas() {
        return repository.findAll().stream()
                .map(inspeccion -> new ResponseInspeccionCalidadDTO(
                        inspeccion.getIdInspeccion(),
                        inspeccion.getIdProducto(),
                        inspeccion.getIdSolicitudProduccion(),
                        inspeccion.getIdCertificacion(),
                        inspeccion.getResultadoInspeccion(),
                        inspeccion.getMetodoMuestreo(),
                        inspeccion.getObservaciones(),
                        inspeccion.getFechaInspeccion()))
                .collect(Collectors.toList());
    }
}