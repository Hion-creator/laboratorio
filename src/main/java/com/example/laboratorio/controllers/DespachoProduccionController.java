package com.example.laboratorio.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.laboratorio.dto.request.RequestDespachoProduccionDTO;
import com.example.laboratorio.dto.response.ResponseDespachoProduccionDTO;
import com.example.laboratorio.services.interfaces.IDespachoProduccionServices;

@RestController
@RequestMapping("/despachoProduccion")
public class DespachoProduccionController {

    private final IDespachoProduccionServices despachoProduccionServices;

    public DespachoProduccionController(IDespachoProduccionServices despachoProduccionServices) {
        this.despachoProduccionServices = despachoProduccionServices;
    }
    //Endpoint para realizar un despacho
    @PostMapping("/realizarDespacho")
    public ResponseDespachoProduccionDTO realizarDespacho(@RequestBody RequestDespachoProduccionDTO requestDespachoProduccionDTO) {
        despachoProduccionServices.crearDespachoProduccion(requestDespachoProduccionDTO);
        ResponseDespachoProduccionDTO response = new ResponseDespachoProduccionDTO();
        response.setMensaje("Despacho realizado correctamente");
        return response;
    }
}
