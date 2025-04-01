package com.example.laboratorio.dto.request;

import lombok.Data;

@Data
public class RequestInspeccionCalidad {
    private Integer idProducto;
    private Integer idSolicitudProduccion;
    private Integer idCertificacion;
    private String resultadoInspeccion;
    private String metodoMuestreo;
    private String observaciones;
}
