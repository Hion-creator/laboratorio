package com.example.laboratorio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.laboratorio.dto.request.RequestProduccionDTO;
import com.example.laboratorio.dto.response.ResponseInventarioProduccionDTO;
import com.example.laboratorio.dto.response.ResponseProduccionDTO;
import com.example.laboratorio.services.impl.ProduccionServices;
import com.example.laboratorio.services.interfaces.IProduccionServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/produccion")
public class ProduccionController {

    private final IProduccionServices produccionServices;

    public ProduccionController(ProduccionServices produccionServices) {
        this.produccionServices = produccionServices;
    }

    @RequestMapping("/getProduccion")
    public ResponseInventarioProduccionDTO getProduccion() {
        return this.produccionServices.getProduccion();
    }

    @PostMapping("/crearProduccion")
    public ResponseProduccionDTO crearProduccion(@RequestBody RequestProduccionDTO requestProduccionDTO) {
        
        ResponseProduccionDTO responseProduccionDTO = this.produccionServices.crearProduccion(requestProduccionDTO);

        return responseProduccionDTO;
    }
    

}
