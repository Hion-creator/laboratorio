package com.example.laboratorio.data;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "detalle_solicitud")
@Data
public class DetalleSolicitudEntity {

    @EmbeddedId
    private DetalleSolicitudPkEntity detalleSolicitudPk;
    
    @Column(name = "cantidad")
    private Long cantidad;
    
    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_solicitud_produccion", insertable = false, updatable = false)
    private SolicitudProduccionEntity solicitudProduccion;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private ProductoEntity producto;

}
