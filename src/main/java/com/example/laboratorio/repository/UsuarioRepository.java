package com.example.laboratorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.laboratorio.data.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
