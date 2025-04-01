package com.example.laboratorio.dto.response;

import lombok.Data;

@Data
public class ResponseDespachoProduccionDTO {

    private Long idDespacho;
    private Long idSolicitudProduccion;
    private String descripcionDespacho;
    private String observacion;
    private int cantidadDespachada;
    private String estado;
    private String mensaje;
}