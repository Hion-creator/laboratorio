package com.example.laboratorio.services.interfaces;

import com.example.laboratorio.dto.request.RequestProduccionDTO;
import com.example.laboratorio.dto.response.ResponseInventarioProduccionDTO;
import com.example.laboratorio.dto.response.ResponseProduccionDTO;

public interface IProduccionServices {

    public ResponseInventarioProduccionDTO getProduccion();

    public ResponseProduccionDTO crearProduccion(RequestProduccionDTO requestProduccionDTO);

}
