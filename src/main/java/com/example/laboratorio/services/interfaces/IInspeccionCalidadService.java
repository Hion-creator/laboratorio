package com.example.laboratorio.services.interfaces;


import java.util.List;

import com.example.laboratorio.dto.request.RequestInspeccionCalidad;
import com.example.laboratorio.dto.response.ResponseInspeccionCalidadDTO;

public interface IInspeccionCalidadService {
    ResponseInspeccionCalidadDTO registrar(RequestInspeccionCalidad request);
    ResponseInspeccionCalidadDTO obtener(int id);
    List<ResponseInspeccionCalidadDTO> obtenerTodas();
}
