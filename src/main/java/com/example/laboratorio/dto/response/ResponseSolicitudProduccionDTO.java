package com.example.laboratorio.dto.response;

import lombok.Data;
import java.util.List;
import java.sql.Timestamp;
import java.util.stream.Collectors;

import com.example.laboratorio.data.SolicitudProduccionEntity;

@Data
public class ResponseSolicitudProduccionDTO {
    private Long idSolicitudProduccion;
    private String descripcion;
    private String observacion;
    private Timestamp fechaSolicitud;
    private Timestamp fechaActualizacion;
    private String estado;
    private List<ResponseDetalleSolicitudDTO> detallesSolicitud;

    // Constructor con la entidad para mapear los datos
    public ResponseSolicitudProduccionDTO(SolicitudProduccionEntity entity) {
        this.idSolicitudProduccion = entity.getIdSolicitudProduccion();
        this.descripcion = entity.getDescripcion();
        this.observacion = entity.getObservacion();
        this.fechaSolicitud = entity.getFechaSolicitud();
        this.fechaActualizacion = entity.getFechaActualizacion();
        this.estado = entity.getEstado();
        this.detallesSolicitud = entity.getDetallesSolicitud().stream()
                .map(ResponseDetalleSolicitudDTO::new)
                .collect(Collectors.toList());
    }
}
