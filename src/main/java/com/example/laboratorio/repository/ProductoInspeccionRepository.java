package com.example.laboratorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.laboratorio.data.ProductoInspeccionEntity;


@Repository
public interface ProductoInspeccionRepository extends JpaRepository<ProductoInspeccionEntity, Long> {
}

