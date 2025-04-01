package com.example.laboratorio.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.laboratorio.dto.response.ResponseEstadoSierraDTO;
import com.example.laboratorio.services.interfaces.SierraService;

@RestController
@RequestMapping("/sierra")
public class SierraController {

    @Autowired
    private SierraService sierraService;
    
    @GetMapping("/estado")
    public ResponseEstadoSierraDTO getEstadoSierra() {
        return sierraService.obtenerEstadoSierra();
    }
}

