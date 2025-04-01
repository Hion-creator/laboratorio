package com.example.laboratorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.laboratorio.data.PruebaInspeccionEntity;

@Repository
public interface PruebaInspeccionRepository extends JpaRepository<PruebaInspeccionEntity, Integer> {
}