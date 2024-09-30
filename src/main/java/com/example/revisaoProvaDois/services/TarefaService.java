package com.example.revisaoProvaDois.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revisaoProvaDois.dtos.req.CreateTarefaDTO;
import com.example.revisaoProvaDois.dtos.req.CreateUsuarioDTO;
import com.example.revisaoProvaDois.dtos.res.ShowRespDTO;
import com.example.revisaoProvaDois.dtos.res.ShowTarefaDTO;
import com.example.revisaoProvaDois.dtos.res.ShowUsuarioDTO;
import com.example.revisaoProvaDois.entities.RespEntity;
import com.example.revisaoProvaDois.entities.TarefaEntity;
import com.example.revisaoProvaDois.entities.UsuarioEntity;
import com.example.revisaoProvaDois.repositories.RespRepository;
import com.example.revisaoProvaDois.repositories.TarefaRepository;
import com.example.revisaoProvaDois.repositories.UsuarioRepository;

@Service
public class TarefaService {

  @Autowired
  TarefaRepository tarefaRepository;

  @Autowired
  RespRepository respRepository;

  @Autowired
  UsuarioRepository usuarioRepository;

  public void createTarefa(CreateTarefaDTO dto) {

    TarefaEntity tarefaEntity = new TarefaEntity();
    tarefaEntity.setTitulo(dto.getTitulo());

    tarefaEntity = tarefaRepository.save(tarefaEntity);

    RespEntity respEntity = new RespEntity();
    respEntity.setNome(dto.getResp().getNome());
    respEntity.setEmail(dto.getResp().getEmail());
    respEntity.setTarefa(tarefaEntity);

    respEntity = respRepository.save(respEntity);

    List<UsuarioEntity> usuariosEntity = new ArrayList<>();

    for (CreateUsuarioDTO usuarioDTO : dto.getUsuarios()) {
      UsuarioEntity usuarioEntity = new UsuarioEntity();
      usuarioEntity.setNome(usuarioDTO.getNome());
      usuarioEntity.setEmail(usuarioDTO.getEmail());
      usuarioEntity.setTarefa(tarefaEntity);

      usuariosEntity.add(usuarioEntity);
    }

    usuarioRepository.saveAll(usuariosEntity);
  }

  public List<ShowTarefaDTO> getAllTarefas() {
    List<TarefaEntity> tarefasEntity = tarefaRepository.findAll();

    return tarefasEntity.stream().map(tarefa -> {
      ShowTarefaDTO tarefaDTO = new ShowTarefaDTO();
      ShowRespDTO respDTO = new ShowRespDTO();
      List<ShowUsuarioDTO> usuariosDTO = new ArrayList<>();

      for (UsuarioEntity usuarioEntity : tarefa.getUsuarios()) {
        ShowUsuarioDTO usuarioDTO = new ShowUsuarioDTO();
        usuarioDTO.setNome(usuarioEntity.getNome());
        usuarioDTO.setEmail(usuarioEntity.getEmail());
        usuariosDTO.add(usuarioDTO);
      }

      respDTO.setNome(tarefa.getResp().getNome());
      respDTO.setEmail(tarefa.getResp().getEmail());

      tarefaDTO.setId(tarefa.getId());
      tarefaDTO.setTitulo(tarefa.getTitulo());
      tarefaDTO.setResp(respDTO);
      tarefaDTO.setUsuarios(usuariosDTO);

      return tarefaDTO;
    }).collect(Collectors.toList());
  }
}
