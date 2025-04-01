package com.example.laboratorio.services.interfaces;

import java.util.List;

import com.example.laboratorio.data.ProductoInspeccionEntity;
import com.example.laboratorio.dto.request.RequestProductoInspeccion;
import com.example.laboratorio.dto.response.ResponseProductoInspeccionDTO;

public interface IProductoInspeccionServices {
    List<ProductoInspeccionEntity> obtenerProductosNoCertificados();
    ResponseProductoInspeccionDTO inspeccionarProducto(RequestProductoInspeccion request);
}
