package com.example.laboratorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.laboratorio.data.DetalleSolicitudEntity;
import com.example.laboratorio.data.DetalleSolicitudPkEntity;


@Repository
public interface DetalleSolicitudRepository extends JpaRepository<DetalleSolicitudEntity, DetalleSolicitudPkEntity> {

    public List<DetalleSolicitudEntity> findByDetalleSolicitudPkIdSolicitudProduccion(Long idSolicitudProduccion);
}
