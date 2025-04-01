package com.example.laboratorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.laboratorio.data.InventarioEntity;


@Repository
public interface InventarioProduccionRepository extends JpaRepository<InventarioEntity, Long> {


}
