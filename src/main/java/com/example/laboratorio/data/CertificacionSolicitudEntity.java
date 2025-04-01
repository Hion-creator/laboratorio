package com.example.laboratorio.data;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "certificacion_solicitud")
@IdClass(CertificacionSolicitudPkEntity.class)
public class CertificacionSolicitudEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_solicitud_produccion", referencedColumnName = "id_solicitud_produccion")
    private SolicitudProduccionEntity solicitudProduccion;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_certificacion", referencedColumnName = "id_certificacion")
    private CertificacionEntity certificacion;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private ProductoEntity producto;

    @Column(name = "cantidad_certificada")
    private int cantidadCertificada;

    @Column(name = "estado")
    private String estado;
}
