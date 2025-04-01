package com.example.laboratorio.dto.response;

import com.example.laboratorio.data.DetalleSolicitudEntity;

import lombok.Data;

@Data
public class ResponseDetalleSolicitudDTO {
    private Long idProducto;
    private Long cantidad;
    private String estado;

    // Constructor con la entidad para mapear los datos
    public ResponseDetalleSolicitudDTO(DetalleSolicitudEntity entity) {
        this.idProducto = entity.getDetalleSolicitudPk().getIdProducto();
        this.cantidad = entity.getCantidad();
        this.estado = entity.getEstado();
    }
}