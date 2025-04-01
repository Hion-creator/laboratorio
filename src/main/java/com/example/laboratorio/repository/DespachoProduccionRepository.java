package com.example.laboratorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.laboratorio.data.CertificacionSolicitudEntity;
import com.example.laboratorio.data.CertificacionSolicitudPkEntity;


@Repository
public interface DespachoProduccionRepository extends JpaRepository<CertificacionSolicitudEntity, CertificacionSolicitudPkEntity> {

}
