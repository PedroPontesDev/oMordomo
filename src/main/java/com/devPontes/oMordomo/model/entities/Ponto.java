package com.devPontes.oMordomo.model.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ponto")
public class Ponto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "horario_entrada")
	private LocalDateTime horarioEntrada;

	@Column(name = "horario_saida")
	private LocalDateTime horarioSaida;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "batedor_ponto.id")
	private BatedorDePonto batedorDePonto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "garcom_id")
	private Garcom garcom;
	
	public Ponto(Long id, LocalDateTime horarioEntrada, LocalDateTime horarioSaida, BatedorDePonto batedorDePonto,
			Garcom garcom) {
		this.id = id;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.batedorDePonto = batedorDePonto;
		this.garcom = garcom;
	}

	public Ponto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(LocalDateTime horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public LocalDateTime getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(LocalDateTime horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public BatedorDePonto getBatedorDePonto() {
		return batedorDePonto;
	}

	public void setBatedorDePonto(BatedorDePonto batedorDePonto) {
		this.batedorDePonto = batedorDePonto;
	}

	public Garcom getGarcom() {
		return garcom;
	}

	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
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
		Ponto other = (Ponto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Ponto [id=" + id + ", horarioEntrada=" + horarioEntrada + ", horarioSaida=" + horarioSaida
				+ ", batedorDePonto=" + batedorDePonto + ", garcom=" + garcom + "]";
	}


	
	
}
