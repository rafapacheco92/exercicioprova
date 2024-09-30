package com.example.revisaoProvaDois.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "usuarios")
public class UsuarioEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "email")
  private String email;

  @ManyToOne
  @JoinColumn(name = "id_tarefa")
  private TarefaEntity tarefa;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public TarefaEntity getTarefa() {
    return tarefa;
  }

  public void setTarefa(TarefaEntity tarefa) {
    this.tarefa = tarefa;
  }

}
