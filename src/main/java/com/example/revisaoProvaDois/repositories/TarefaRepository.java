package com.example.revisaoProvaDois.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.revisaoProvaDois.entities.TarefaEntity;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {

}
