package com.example.laboratorio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.laboratorio.dto.response.ResponseInventarioProduccionDTO;
import com.example.laboratorio.services.impl.InventarioProduccionServices;
import com.example.laboratorio.services.interfaces.IInventarioProduccionServices;


@RestController
@RequestMapping("/inventarioProduccion")
public class InventarioProduccionCrontroller {

    private final IInventarioProduccionServices inventarioProduccionServices;

    public InventarioProduccionCrontroller(InventarioProduccionServices inventarioProduccionServices) {
        this.inventarioProduccionServices = inventarioProduccionServices;
    }

    @RequestMapping("/getInventarioProduccion")
    public ResponseInventarioProduccionDTO getInventarioProduccion() {

        ResponseInventarioProduccionDTO response = this.inventarioProduccionServices.getInventarioProduccion();

        return response;
    }
    

}
