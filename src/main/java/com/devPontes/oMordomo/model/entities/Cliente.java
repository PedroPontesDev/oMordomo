package com.devPontes.oMordomo.model.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
@PrimaryKeyJoinColumn(name = "usuario.id")
@DiscriminatorValue("CLIENTE")
public class Cliente extends Usuario {
	private static final long serialVersionUID = 1L;

	@Column(name = "valor_pago")
	private Double valorDePagamento;

	@Column(name = "houve_pagamento")
	private Boolean pagou;

	public Cliente(String fullName, String email, String username, String password, Long cpf, Double valorDePagamento,
			Boolean pagou) {
		super(fullName, email, username, password, cpf);
		this.valorDePagamento = valorDePagamento;
		this.pagou = pagou;
	}

	public Cliente() {

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

	@Override
	public int hashCode() {
		return Objects.hash(valorDePagamento);
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
