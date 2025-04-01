package com.example.laboratorio.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.laboratorio.data.CertificacionSolicitudEntity;
import com.example.laboratorio.data.CertificacionSolicitudPkEntity;
import com.example.laboratorio.data.UsuarioEntity;
import com.example.laboratorio.dto.request.RequestDespachoProduccionDTO;
import com.example.laboratorio.dto.response.ResponseDespachoProduccionDTO;
import com.example.laboratorio.repository.DespachoProduccionRepository;
import com.example.laboratorio.repository.UsuarioRepository;
import com.example.laboratorio.services.interfaces.IDespachoProduccionServices;

import java.util.Optional;

@Service
public class DespachoProduccionServices implements IDespachoProduccionServices {

    @Autowired
    private DespachoProduccionRepository despachoProduccionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void crearDespachoProduccion(RequestDespachoProduccionDTO despachoProduccionDTO) {
        CertificacionSolicitudPkEntity certificacionPk = new CertificacionSolicitudPkEntity(despachoProduccionDTO.getIdSolicitudProduccion(), despachoProduccionDTO.getIdProducto(),despachoProduccionDTO.getIdCertificacion());
        Optional<CertificacionSolicitudEntity> certificacionOpt = despachoProduccionRepository.findById(certificacionPk);

        if (certificacionOpt.isPresent()) {
            CertificacionSolicitudEntity certificacion = certificacionOpt.get();
            Long idUsuario = certificacion.getSolicitudProduccion().getIdUsuario();
            UsuarioEntity usuario = usuarioRepository.findById(idUsuario).orElse(null);

            if (usuario != null) {
                ResponseDespachoProduccionDTO response = new ResponseDespachoProduccionDTO();
                response.setIdSolicitudProduccion(certificacion.getSolicitudProduccion().getIdSolicitudProduccion());
                response.setCantidadDespachada(certificacion.getCantidadCertificada());
                response.setEstado(certificacion.getEstado());
                response.setMensaje("Despacho realizado con éxito para el cliente: " + usuario.getNombre() + " " + usuario.getApellido());
                System.out.println(response);
            } else {
                System.out.println("Usuario no encontrado");
            }
        } else {
            System.out.println("Certificación no encontrada");
        }
    }
}