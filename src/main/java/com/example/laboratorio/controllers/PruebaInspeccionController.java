package com.example.laboratorio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.laboratorio.dto.request.RequestPruebaInspeccion;
import com.example.laboratorio.services.interfaces.IPruebaInspeccionServices;


@RestController
@RequestMapping("/prueba")
public class PruebaInspeccionController {
    // Este es un controlador para la entidad PruebaInspeccion

    @Autowired
    private IPruebaInspeccionServices service;

    // Este método se utiliza para registrar una nueva PruebaInspeccion
    // http://localhost:8011/prueba/registrar

    /*
     * {
     * "idInspeccion": 1,
     * "tipoMaterial": "Acero",
     * "metodoPrueba": "Ultrasonido",
     * "resultado": 85.5,
     * "cumpleEstandar": true
     * }
     */
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody RequestPruebaInspeccion request) {
        try {
            return ResponseEntity.ok(service.registrar(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar la prueba: " + e.getMessage());
        }
    }
// Este método se utiliza consultar los registros validados
    // http://localhost:8011/prueba/1
    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable int id) {
        try {
            return ResponseEntity.ok(service.obtener(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}