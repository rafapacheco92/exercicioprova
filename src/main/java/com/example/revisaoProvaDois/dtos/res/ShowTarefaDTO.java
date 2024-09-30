package com.example.revisaoProvaDois.dtos.res;

import java.util.List;

public class ShowTarefaDTO {

  private Long id;
  private String titulo;
  private ShowRespDTO resp;
  private List<ShowUsuarioDTO> usuarios;

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

  public ShowRespDTO getResp() {
    return resp;
  }

  public void setResp(ShowRespDTO resp) {
    this.resp = resp;
  }

  public List<ShowUsuarioDTO> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<ShowUsuarioDTO> usuarios) {
    this.usuarios = usuarios;
  }

}
