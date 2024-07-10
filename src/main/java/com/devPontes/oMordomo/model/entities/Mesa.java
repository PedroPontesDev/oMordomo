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
	@Column(name = "identificador", unique = true)
	private Long id;

	@Enumerated(EnumType.STRING)
	private StatusMesa statusMesa;

	@OneToOne(mappedBy = "mesa", cascade = CascadeType.ALL)
	private Comanda comanda;

	@Column(name = "horario_ocupacao")
	private LocalDateTime horarioOcupacao;

	@Column(name = "horario_desocupacao")
    @JsonFormat(pattern = "yyyy/MM/dd'T'HH:mm:ss'Z'", timezone = "GMT", shape = Shape.STRING)
	private LocalDateTime horarioSaida;

	@Column(name = "total_horas_ocupacao")
    @JsonFormat(pattern = "yyyy/MM/dd'T'HH:mm:ss'Z'", timezone = "GMT", shape = Shape.STRING)
	private Long totalDeHorasMesa;

	public Mesa(Long id, StatusMesa statusMesa, Comanda comanda, LocalDateTime horarioOcupacao,
			LocalDateTime horarioSaida, Long totalDeHorasMesa) {
		this.id = id;
		this.statusMesa = statusMesa;
		this.comanda = comanda;
		this.horarioOcupacao = horarioOcupacao;
		this.horarioSaida = horarioSaida;
		this.totalDeHorasMesa = totalDeHorasMesa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getHorarioOcupacao() {
		return horarioOcupacao;
	}

	public void setHorarioOcupacao(LocalDateTime horarioOcupacao) {
		this.horarioOcupacao = horarioOcupacao;
	}

	public LocalDateTime getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(LocalDateTime horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public Long getTotalDeHorasMesa() {
		return totalDeHorasMesa;
	}

	public void setTotalDeHorasMesa(Long totalDeHorasMesa) {
		this.totalDeHorasMesa = totalDeHorasMesa;
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
