package com.example.revisaoProvaDois.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.revisaoProvaDois.entities.RespEntity;

@Repository
public interface RespRepository extends JpaRepository<RespEntity, Long> {

}
