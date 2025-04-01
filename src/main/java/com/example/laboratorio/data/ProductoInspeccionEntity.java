package com.example.laboratorio.data;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "certificacion_solicitud")
public class ProductoInspeccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    private Long id_solicitud_produccion;
    private Long id_certificacion;
    private Integer cantidad_certificada;
    private String estado;
   
   private String resultado_inspeccion;
    private String observaciones;
}