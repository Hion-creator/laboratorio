package com.example.laboratorio.services.interfaces;

import com.example.laboratorio.dto.request.RequestPruebaInspeccion;
import com.example.laboratorio.dto.response.ResponsePruebaInspeccionDTO;

public interface IPruebaInspeccionServices {
    ResponsePruebaInspeccionDTO registrar(RequestPruebaInspeccion request);
    ResponsePruebaInspeccionDTO obtener(int id);
}