package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.devPontes.oMordomo.model.enums.StatusMesa;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_mesa")
public class Mesa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private StatusMesa statusMesa;
	
	@Column(name = "dia_reserva")
	private LocalDateTime diaDaReserva;
	
	@Column(name = "esta_reservada")
	private Boolean estaReservada;

	@OneToOne(mappedBy = "mesa")
	private Comanda comanda;

	public Mesa(Long id, StatusMesa statusMesa, LocalDateTime diaDaReserva, Boolean estaReservada, Comanda comanda) {
		this.id = id;
		this.statusMesa = statusMesa;
		this.diaDaReserva = diaDaReserva;
		this.estaReservada = estaReservada;
		this.comanda = comanda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusMesa getStatusMesa() {
		return statusMesa;
	}

	public void setStatusMesa(StatusMesa statusMesa) {
		this.statusMesa = statusMesa;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public LocalDateTime getDiaDaReserva() {
		return diaDaReserva;
	}

	public void setDiaDaReserva(LocalDateTime diaDaReserva) {
		this.diaDaReserva = diaDaReserva;
	}
	

	public Boolean getEstaReservada() {
		if(statusMesa == StatusMesa.RESERVADA) {
			return true;
		} return false;
	}
	
	public void setEstaReservada(Boolean estaReservada) {
		this.estaReservada = estaReservada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Mesa [id=" + id + ", statusMesa=" + statusMesa + ", comanda=" + comanda + "]";
	}

}
