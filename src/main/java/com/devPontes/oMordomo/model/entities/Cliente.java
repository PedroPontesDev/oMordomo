package com.devPontes.oMordomo.model.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
@PrimaryKeyJoinColumn(name = "usuario.id")
@DiscriminatorValue("CLIENTE")
public class Cliente extends Usuario {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name = "houve_pagamento")
	private Boolean pagou;

	@OneToOne(mappedBy = "clienteComanda")
	private Comanda comandaCliente;

	@Column(name = "valor_pago")
	private Double valorDePagamento;

	@Column(name = "num_frequencia_consumo")
	private Integer frequenciaDeConsumo;

	public Cliente(Long id, String fullName, String email, Long cpf, Boolean accountNonExpired,
			Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled, String username, String password,
			List<Permissao> permissoes, Boolean pagou, Comanda comandaCliente, Double valorDePagamento,
			Integer frequenciaDeConsumo) {
		super(id, fullName, email, cpf, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, username,
				password, permissoes);
		this.pagou = pagou;
		this.comandaCliente = comandaCliente;
		this.valorDePagamento = valorDePagamento;
		this.frequenciaDeConsumo = frequenciaDeConsumo;
	}

	public Cliente() {

	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return super.getFullName();
	}

	@Override
	public Boolean getAccountNonExpired() {
		// TODO Auto-generated method stub
		return super.getAccountNonExpired();
	}

	@Override
	public void setAccountNonExpired(Boolean accountNonExpired) {
		// TODO Auto-generated method stub
		super.setAccountNonExpired(accountNonExpired);
	}

	@Override
	public Boolean getAccountNonLocked() {
		// TODO Auto-generated method stub
		return super.getAccountNonLocked();
	}

	@Override
	public void setAccountNonLocked(Boolean accountNonLocked) {
		// TODO Auto-generated method stub
		super.setAccountNonLocked(accountNonLocked);
	}

	@Override
	public Boolean getCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return super.getCredentialsNonExpired();
	}

	@Override
	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		// TODO Auto-generated method stub
		super.setCredentialsNonExpired(credentialsNonExpired);
	}

	@Override
	public Boolean getEnabled() {
		// TODO Auto-generated method stub
		return super.getEnabled();
	}

	@Override
	public void setEnabled(Boolean enabled) {
		// TODO Auto-generated method stub
		super.setEnabled(enabled);
	}

	@Override
	public void setFullName(String fullName) {
		// TODO Auto-generated method stub
		super.setFullName(fullName);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		super.setUsername(username);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public Long getCpf() {
		// TODO Auto-generated method stub
		return super.getCpf();
	}

	@Override
	public void setCpf(Long cpf) {
		// TODO Auto-generated method stub
		super.setCpf(cpf);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getPagou() {
		return pagou;
	}

	public void setPagou(Boolean pagou) {
		this.pagou = pagou;
	}

	public Double getValorDePagamento() {
		return valorDePagamento;
	}

	public void setValorDePagamento(Double valorDePagamento) {
		this.valorDePagamento = valorDePagamento;
	}

	public Integer getFrequenciaDeConsumo() {
		return frequenciaDeConsumo;
	}

	public void setFrequenciaDeConsumo(Integer frequenciaDeConsumo) {
		this.frequenciaDeConsumo = frequenciaDeConsumo;
	}

	public Comanda getComandaCliente() {
		return comandaCliente;
	}

	public void setComandaCliente(Comanda comandaCliente) {
		this.comandaCliente = comandaCliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(valorDePagamento);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(valorDePagamento, other.valorDePagamento);
	}

	@Override
	public String toString() {
		return "Cliente [valorDePagamento=" + valorDePagamento + "]";
	}

}
