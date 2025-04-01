package com.example.laboratorio.services.impl;

import java.sql.Timestamp;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laboratorio.data.DetalleSolicitudEntity;
import com.example.laboratorio.data.DetalleSolicitudPkEntity;
import com.example.laboratorio.data.SolicitudProduccionEntity;
import com.example.laboratorio.dto.request.RequestDetalleSolicitudDTO;
import com.example.laboratorio.dto.request.RequestSolicitudProduccionDTO;
import com.example.laboratorio.dto.response.ResponseSolicitudProduccionDTO;
import com.example.laboratorio.repository.DetalleSolicitudRepository;
import com.example.laboratorio.repository.SolicitudProduccionRepository;
import com.example.laboratorio.services.interfaces.ISolicitudProduccionServices;


@Service
public class SolicitudProduccionServices implements ISolicitudProduccionServices {

    @Autowired
    private SolicitudProduccionRepository solicitudProduccionRepository;

    @Autowired
    private DetalleSolicitudRepository detalleSolicitudRepository;

    @Override
    public void crearSolicitudProduccion(RequestSolicitudProduccionDTO solicitudProduccionDTO) {
        
        // Validaciones de la solicitud principal
        Objects.requireNonNull(solicitudProduccionDTO, "La solicitud de producción no puede ser nula.");
        Objects.requireNonNull(solicitudProduccionDTO.getDescripcion(), "La descripción no puede ser nula.");
        Objects.requireNonNull(solicitudProduccionDTO.getObservacion(), "La observación no puede ser nula.");
        Objects.requireNonNull(solicitudProduccionDTO.getIdUsuario(), "El ID de usuario no puede ser nulo.");
        
        if (solicitudProduccionDTO.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }

        if (solicitudProduccionDTO.getObservacion().trim().isEmpty()) {
            throw new IllegalArgumentException("La observación no puede estar vacía.");
        }

        if (solicitudProduccionDTO.getDetalleSolicitud() == null || solicitudProduccionDTO.getDetalleSolicitud().isEmpty()) {
            throw new IllegalArgumentException("Debe haber al menos un detalle en la solicitud.");
        }

        // Creación de la entidad principal
        SolicitudProduccionEntity solicitudProduccionEntity = new SolicitudProduccionEntity();

        solicitudProduccionEntity.setDescripcion(solicitudProduccionDTO.getDescripcion().trim());
        solicitudProduccionEntity.setFechaSolicitud(new Timestamp(System.currentTimeMillis()));
        solicitudProduccionEntity.setFechaActualizacion(new Timestamp(System.currentTimeMillis()));
        solicitudProduccionEntity.setEstado("Inicial");
        solicitudProduccionEntity.setObservacion(solicitudProduccionDTO.getObservacion().trim());
        solicitudProduccionEntity.setIdUsuario(solicitudProduccionDTO.getIdUsuario());

        solicitudProduccionRepository.save(solicitudProduccionEntity);

        // Procesar detalles de la solicitud
        for(RequestDetalleSolicitudDTO detalleSolicitudDTO : solicitudProduccionDTO.getDetalleSolicitud()) {
            
            // Validaciones de cada detalle
            Objects.requireNonNull(detalleSolicitudDTO.getIdProducto(), "El ID del producto no puede ser nulo.");
            Objects.requireNonNull(detalleSolicitudDTO.getCantidad(), "La cantidad no puede ser nula.");

            if (detalleSolicitudDTO.getCantidad() <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
            }

            DetalleSolicitudEntity detalleSolicitudEntity = new DetalleSolicitudEntity();
            DetalleSolicitudPkEntity detalleSolicitudPkEntity = new DetalleSolicitudPkEntity();

            detalleSolicitudPkEntity.setIdProducto(detalleSolicitudDTO.getIdProducto());
            detalleSolicitudPkEntity.setIdSolicitudProduccion(solicitudProduccionEntity.getIdSolicitudProduccion());
            
            detalleSolicitudEntity.setDetalleSolicitudPk(detalleSolicitudPkEntity);
            detalleSolicitudEntity.setCantidad(detalleSolicitudDTO.getCantidad());
            detalleSolicitudEntity.setSolicitudProduccion(solicitudProduccionEntity);
            detalleSolicitudEntity.setEstado("Inicial");

            detalleSolicitudRepository.save(detalleSolicitudEntity);
        }
    }

    @Override
    public ResponseSolicitudProduccionDTO consultarSolicitudProduccion(long id) {

        SolicitudProduccionEntity entity = solicitudProduccionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        return new ResponseSolicitudProduccionDTO(entity);
        
    }
}