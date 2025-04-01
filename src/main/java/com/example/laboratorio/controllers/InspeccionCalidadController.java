package com.example.laboratorio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.laboratorio.dto.request.RequestInspeccionCalidad;
import com.example.laboratorio.dto.response.ResponseInspeccionCalidadDTO;
import com.example.laboratorio.services.interfaces.IInspeccionCalidadService;

import java.util.List;

@RestController
@RequestMapping("/inspeccion")
public class InspeccionCalidadController {

    @Autowired
    private IInspeccionCalidadService service;

   /*  http://localhost:8011/inspeccion/registrar
   {
    "idProducto": 1,
    "idSolicitudProduccion": 456,
    "idCertificacion": 789,
    "resultadoInspeccion": "Aprobado",
    "metodoMuestreo": "MIL-STD-105E",
    "observaciones": "Cumple con los estándares"
}
*/

    @PostMapping("/registrar")
    public ResponseEntity<ResponseInspeccionCalidadDTO> registrar(@RequestBody RequestInspeccionCalidad request) {
        return ResponseEntity.ok(service.registrar(request));
    }

    // http://localhost:8011/inspeccion/n
    @GetMapping("/{id}")
    public ResponseEntity<ResponseInspeccionCalidadDTO> obtener(@PathVariable int id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseInspeccionCalidadDTO>> obtenerTodas() {
        return ResponseEntity.ok(service.obtenerTodas());
    }
}
