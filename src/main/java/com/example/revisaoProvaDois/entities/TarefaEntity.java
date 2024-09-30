package com.example.revisaoProvaDois.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tarefas")
public class TarefaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "titulo")
  private String titulo;

  @OneToOne(mappedBy = "tarefa")
  private RespEntity resp;

  @OneToMany(mappedBy = "tarefa")
  private List<UsuarioEntity> usuarios;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public RespEntity getResp() {
    return resp;
  }

  public void setResp(RespEntity resp) {
    this.resp = resp;
  }

  public List<UsuarioEntity> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<UsuarioEntity> usuarios) {
    this.usuarios = usuarios;
  }

}
