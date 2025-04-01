package com.example.laboratorio.dto.request;

import lombok.Data;

@Data
public class RequestDespachoProduccionDTO {

    private Long idSolicitudProduccion;
    private Long idCertificacion;
    private Long idProducto;
    private Long cantidadCertificada;

}