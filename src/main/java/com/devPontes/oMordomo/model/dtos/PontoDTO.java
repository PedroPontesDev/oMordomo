package com.devPontes.oMordomo.model.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class PontoDTO extends RepresentationModel<PontoDTO> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private LocalDateTime horarioEntrada;
	private LocalDateTime horarioSaida;

	@JsonFormat(pattern = "yyyy/MM/dd", shape = Shape.STRING)
	@JsonProperty(value = "dataMesFalta")
	private LocalDate dataDoMes;

	@JsonIgnore
	private BatedorDePontoDTO batedorDePonto;

	private Long garcomId;

	public PontoDTO(Long id, LocalDateTime horarioEntrada, LocalDateTime horarioSaida, LocalDate dataDoMes,
			BatedorDePontoDTO batedorDePonto, Long garcomId) {
		this.id = id;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.dataDoMes = dataDoMes;
		this.batedorDePonto = batedorDePonto;
		this.garcomId = garcomId;
	}

	public PontoDTO() {
	}

	public LocalDate getDataDoMes() {
		return dataDoMes;
	}

	public void setDataDoMes(LocalDate dataDoMes) {
		this.dataDoMes = dataDoMes;
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

	public BatedorDePontoDTO getBatedorDePonto() {
		return batedorDePonto;
	}

	public void setBatedorDePonto(BatedorDePontoDTO batedorDePonto) {
		this.batedorDePonto = batedorDePonto;
	}

	public Long getGarcomId() {
		return garcomId;
	}

	public void setGarcomId(Long garcomId) {
		this.garcomId = garcomId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(batedorDePonto, garcomId, id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PontoDTO other = (PontoDTO) obj;
		return Objects.equals(batedorDePonto, other.batedorDePonto) && Objects.equals(garcomId, other.garcomId)
				&& Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "PontoDTO [id=" + id + ", horarioEntrada=" + horarioEntrada + ", horarioSaida=" + horarioSaida
				+ ", batedorDePonto=" + batedorDePonto + ", garcomId=" + garcomId + "]";
	}

}
