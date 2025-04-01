
package com.example.laboratorio.dto.request;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RequestPruebaInspeccion {
    private Integer idPrueba;
    private int idInspeccion;
    private String tipoMaterial;
    private String metodoPrueba;
    private BigDecimal resultado;
    private boolean cumpleEstandar;
    private LocalDateTime fechaPrueba;
}