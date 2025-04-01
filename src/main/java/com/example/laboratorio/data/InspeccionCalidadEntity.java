package com.example.laboratorio.data;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inspeccion_calidad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspeccionCalidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inspeccion")
    private Integer idInspeccion ;

    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "id_solicitud_produccion")
    private Integer idSolicitudProduccion;

    @Column(name = "id_certificacion")
    private Integer idCertificacion;

    @Column(name = "resultado_inspeccion")
    private String resultadoInspeccion;

    @Column(name = "metodo_muestreo")
    private String metodoMuestreo;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "fecha_inspeccion")
    private LocalDateTime fechaInspeccion;


}
