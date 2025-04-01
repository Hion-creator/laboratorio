package com.example.laboratorio.repository;
//db
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.laboratorio.data.SolicitudProduccionEntity;


@Repository
public interface SolicitudProduccionRepository extends JpaRepository<SolicitudProduccionEntity, Long> {

    //deseo hacer un metodo que me traiga la solicitud de produccion con fecha menor a un parametro de entrada que se llama fecha de corte
    public List<SolicitudProduccionEntity> findByFechaSolicitudBefore(Timestamp fechaCorte);

    public SolicitudProduccionEntity findByIdSolicitudProduccion(long id); // metodo para traer una solicitud en base a un ID


}
