package com.example.laboratorio.services.interfaces;

import com.example.laboratorio.dto.request.RequestSolicitudProduccionDTO;
import com.example.laboratorio.dto.response.ResponseSolicitudProduccionDTO;

public interface ISolicitudProduccionServices {

    public void crearSolicitudProduccion(RequestSolicitudProduccionDTO solicitudProduccionDTO);

    public ResponseSolicitudProduccionDTO consultarSolicitudProduccion(long id);


}
