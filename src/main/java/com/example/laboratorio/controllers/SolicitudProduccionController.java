package com.example.laboratorio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.laboratorio.dto.request.RequestSolicitudProduccionDTO;
import com.example.laboratorio.dto.response.ResponseSolicitudProduccionDTO;
import com.example.laboratorio.services.impl.SolicitudProduccionServices;
import com.example.laboratorio.services.interfaces.ISolicitudProduccionServices;


@RestController
@RequestMapping("/solicitudProduccion")
public class SolicitudProduccionController {

    private final ISolicitudProduccionServices solicitudProduccionServices;

    public SolicitudProduccionController(SolicitudProduccionServices solicitudProduccionServices) {
        this.solicitudProduccionServices = solicitudProduccionServices;
    }

    @PostMapping("/crearSolicitudProduccion")
    public void crearSolicitudProduccion(@RequestBody RequestSolicitudProduccionDTO requestSolicitudProduccionDTO) {

        this.solicitudProduccionServices.crearSolicitudProduccion(requestSolicitudProduccionDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSolicitudProduccionDTO> obtenerSolicitud(@PathVariable Long id) {
        ResponseSolicitudProduccionDTO response = solicitudProduccionServices.consultarSolicitudProduccion(id);
        return ResponseEntity.ok(response);
    }
}
