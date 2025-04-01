package com.example.laboratorio.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificacionSolicitudPkEntity implements Serializable {
    
    private Long solicitudProduccion;
    private Long certificacion; 
    private Long producto;
}
