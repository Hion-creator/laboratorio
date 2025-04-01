package com.example.laboratorio.dto.request;

import lombok.Data;

@Data
public class RequestProductoInspeccion {
    private Long id_producto;
    private Long id_solicitud_produccion;
    private Long id_certificacion;
    private Integer cantidad_certificada;
    private String estado;
    private String resultadoInspeccion;
    private String observaciones;
}

