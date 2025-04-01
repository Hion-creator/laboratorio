package com.example.laboratorio.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class DetalleSolicitudPkEntity {

    @Column(name = "id_solicitud_produccion")
    private Long idSolicitudProduccion;

    @Column(name = "id_producto")
    private Long idProducto;

}
