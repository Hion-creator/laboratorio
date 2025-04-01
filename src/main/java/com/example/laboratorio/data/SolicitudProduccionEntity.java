package com.example.laboratorio.data;



import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "solicitud_produccion")
@Data
public class SolicitudProduccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud_produccion")
    private Long idSolicitudProduccion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha_solicitud")
    private Timestamp fechaSolicitud;

    @Column(name = "fecha_actualizacion")
    private Timestamp fechaActualizacion;

    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "solicitudProduccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleSolicitudEntity> detallesSolicitud;

    @Column(name = "id_usuario")
    private Long idUsuario;
}
