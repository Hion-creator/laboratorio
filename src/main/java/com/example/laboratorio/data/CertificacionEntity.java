package com.example.laboratorio.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "certificacion")
@Data
public class CertificacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certificacion")
    private Long idCertificacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_certificacion")
    private String fechaCertificacion;

    @Column(name = "estado")
    private String estado;
}
