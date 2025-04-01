package com.example.laboratorio.dto.response;


import lombok.Data;

@Data
public class ResponseProductoProduccionDTO {

    private Long idProducto;
    private Long cantidad;
    private String estado;

}
