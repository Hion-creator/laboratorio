package com.example.laboratorio.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.laboratorio.dto.request.RequestPruebaInspeccion;

@Builder
@Entity
@Table(name = "prueba_control")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PruebaInspeccionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prueba")
    private Integer idPrueba;

    @Column(name = "id_inspeccion")
    private Integer idInspeccion;

    @Column(name = "tipo_material")
    private String tipoMaterial;

    @Column(name = "metodo_prueba")
    private String metodoPrueba;

    @Column(name = "resultado")
    private BigDecimal resultado;

    @Column(name = "cumple_estandar")
    private Boolean cumpleEstandar;

    @Column(name = "fecha_prueba")
    private LocalDateTime fechaPrueba;

    // Constructor para convertir RequestPruebaInspeccion en entidad
    public PruebaInspeccionEntity(RequestPruebaInspeccion request) {
        this.idInspeccion = request.getIdInspeccion();
        this.tipoMaterial = request.getTipoMaterial();
        this.metodoPrueba = request.getMetodoPrueba();
        this.resultado = request.getResultado();
        this.cumpleEstandar = request.isCumpleEstandar();
        this.fechaPrueba = request.getFechaPrueba() != null ? request.getFechaPrueba() : LocalDateTime.now();
    }
}
