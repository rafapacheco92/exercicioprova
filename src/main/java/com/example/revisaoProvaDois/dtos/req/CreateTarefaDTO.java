package com.example.revisaoProvaDois.dtos.req;

import java.util.List;

public class CreateTarefaDTO {

  private String titulo;
  private CreateRespDTO resp;
  private List<CreateUsuarioDTO> usuarios;

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public CreateRespDTO getResp() {
    return resp;
  }

  public void setResp(CreateRespDTO resp) {
    this.resp = resp;
  }

  public List<CreateUsuarioDTO> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<CreateUsuarioDTO> usuarios) {
    this.usuarios = usuarios;
  }

}
