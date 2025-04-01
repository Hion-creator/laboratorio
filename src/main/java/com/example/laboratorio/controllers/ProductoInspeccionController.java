package com.example.laboratorio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.laboratorio.data.ProductoInspeccionEntity;
import com.example.laboratorio.dto.request.RequestProductoInspeccion;
import com.example.laboratorio.dto.response.ResponseProductoInspeccionDTO;
import com.example.laboratorio.services.interfaces.IProductoInspeccionServices;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoInspeccionController {

    @Autowired
    private IProductoInspeccionServices productoInspeccionServices;

    // 📌 Obtener productos sin certificación
    @GetMapping("/no-certificados")
    public ResponseEntity<List<ProductoInspeccionEntity>> obtenerProductosNoCertificados() {
        List<ProductoInspeccionEntity> productos = productoInspeccionServices.obtenerProductosNoCertificados();
        return ResponseEntity.ok(productos);
    }

    // 📌 Inspeccionar producto
    @PostMapping("/inspeccionar")
    public ResponseEntity<ResponseProductoInspeccionDTO> inspeccionarProducto(@RequestBody RequestProductoInspeccion request) {
        ResponseProductoInspeccionDTO response = productoInspeccionServices.inspeccionarProducto(request);
        return ResponseEntity.ok(response);
    }
}
