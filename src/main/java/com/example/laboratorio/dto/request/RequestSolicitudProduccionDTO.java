package com.example.laboratorio.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class RequestSolicitudProduccionDTO {

    private String descripcion;
    private String observacion;
    private String estado;
    private Long idUsuario;
    private List<RequestDetalleSolicitudDTO> detalleSolicitud;
    private Integer id;
    
}
