package com.example.revisaoProvaDois.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.revisaoProvaDois.dtos.req.CreateTarefaDTO;
import com.example.revisaoProvaDois.dtos.res.ShowTarefaDTO;
import com.example.revisaoProvaDois.services.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaContoller {

  @Autowired
  TarefaService tarefaService;

  @PostMapping
  public ResponseEntity<?> createTarefa(@RequestBody CreateTarefaDTO dto) {
    System.out.println(dto.getTitulo());
    System.out.println(dto.getResp().getNome());
    System.out.println(dto.getUsuarios().get(0).getNome());

    tarefaService.createTarefa(dto);

    return ResponseEntity.status(201).build();
  }

  @GetMapping
  public ResponseEntity<?> getAllTarefas() {
    List<ShowTarefaDTO> tarefas = tarefaService.getAllTarefas();

    return ResponseEntity.status(200).body(tarefas);
  }
}
