package com.example.laboratorio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.laboratorio.data.PruebaInspeccionEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePruebaInspeccionDTO {
    
    private Integer idPrueba;
    private Integer idInspeccion;
    private String tipoMaterial;
    private String metodoPrueba;
    private BigDecimal resultado;
    private Boolean cumpleEstandar;
    private LocalDateTime fechaPrueba;

    // Constructor para convertir la entidad en DTO
    public ResponsePruebaInspeccionDTO(PruebaInspeccionEntity entity) {
        this.idPrueba = entity.getIdPrueba();
        this.idInspeccion = entity.getIdInspeccion();
        this.tipoMaterial = entity.getTipoMaterial();
        this.metodoPrueba = entity.getMetodoPrueba();
        this.resultado = entity.getResultado();
        this.cumpleEstandar = entity.getCumpleEstandar();
        this.fechaPrueba = entity.getFechaPrueba();
    }
}
