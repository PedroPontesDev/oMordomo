package com.devPontes.oMordomo.model.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PermissaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;

	@JsonIgnore
	private List<UsuarioDTO> usuarios = new ArrayList<>();

	public PermissaoDTO() {
	}

	public PermissaoDTO(Long id, String nome, List<UsuarioDTO> usuarios) {
		this.id = id;
		this.nome = nome;
		this.usuarios = usuarios;
	}
	
	
	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "PermissaoDTO [id=" + id + ", nome=" + nome + "]";
	}
}
