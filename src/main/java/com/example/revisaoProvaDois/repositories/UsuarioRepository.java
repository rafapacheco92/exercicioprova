package com.example.revisaoProvaDois.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.revisaoProvaDois.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
