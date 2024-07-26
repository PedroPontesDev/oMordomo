package com.devPontes.oMordomo.model.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

	public Cliente(Long id, String fullName, String email, String username, String password, Long cpf, Boolean pagou,
			Comanda comandaCliente, Double valorDePagamento, Integer frequenciaDeConsumo) {
		super(id, fullName, email, username, password, cpf);
		this.pagou = pagou;
		this.comandaCliente = comandaCliente;
		this.valorDePagamento = valorDePagamento;
		this.frequenciaDeConsumo = frequenciaDeConsumo;
	}

	public Cliente() {

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
