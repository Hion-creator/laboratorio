package com.example.laboratorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.laboratorio.data.InspeccionCalidadEntity;

@Repository
public interface InspeccionCalidadRepository extends JpaRepository<InspeccionCalidadEntity, Integer> {
}
