package com.example.laboratorio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInspeccionCalidadDTO {
    private Integer idIinspeccion;
    private Integer idProducto;
    private Integer idSolicitudProduccion;
    private Integer idCertificacion;
    private String resultadoInspeccion;
    private String metodoMuestreo;
    private String observaciones;
    private LocalDateTime fechaInspeccion;
}


