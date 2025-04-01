package com.example.laboratorio.dto.response;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class ResponseProductoInspeccionDTO {
    private String resultadoInspeccion;
    private String observaciones;
}
