package com.devPontes.oMordomo.model.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder("id, horarioEntrada, horarioSaida, pontos, dataDoMes, dataDaFalta, teveFalta")
public class BatedorDePontoDTO extends RepresentationModel<BatedorDePontoDTO> {
		
	
	private Long id;
	
	private String nome;
	
	@JsonFormat(pattern = "dd/mm/yyyy'T'HH:mm:ss'T'Z'", shape = Shape.STRING, timezone = "GMT")
	private LocalDateTime horarioEntrada;
	
	@JsonFormat(pattern = "dd/mm/yyyy'T'HH:mm:ssT'Z'", shape = Shape.STRING)
	private LocalDateTime horarioSaida;
	
	@JsonFormat(pattern = "dd/mm/yyyy", shape = Shape.STRING)
	private LocalDate dataDoMes;
	
	@JsonFormat(pattern = "dd/mm/yyyy", shape = Shape.STRING)
	private LocalDate dataDaFalta;
	
	private List<PontoDTO> pontos = new ArrayList<>();
	
	@JsonProperty(value = "houveFalta")
	private Boolean teveFalta;

	public BatedorDePontoDTO(Long id, LocalDateTime horarioEntrada, LocalDateTime horarioSaida, LocalDate dataDoMes,
			LocalDate dataDaFalta, List<PontoDTO> pontos, Boolean teveFalta) {
		this.id = id;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.dataDoMes = dataDoMes;
		this.dataDaFalta = dataDaFalta;
		this.pontos = pontos;
		this.teveFalta = teveFalta;
	}
	
	public BatedorDePontoDTO() {
		
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

	public LocalDate getDataDoMes() {
		return dataDoMes;
	}

	public void setDataDoMes(LocalDate dataDoMes) {
		this.dataDoMes = dataDoMes;
	}

	public LocalDate getDataDaFalta() {
		return dataDaFalta;
	}

	public void setDataDaFalta(LocalDate dataDaFalta) {
		this.dataDaFalta = dataDaFalta;
	}

	public List<PontoDTO> getPontos() {
		return pontos;
	}

	public void setPontos(List<PontoDTO> pontos) {
		this.pontos = pontos;
	}

	public Boolean getTeveFalta() {
		return teveFalta;
	}

	public void setTeveFalta(Boolean teveFalta) {
		this.teveFalta = teveFalta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id);
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
		BatedorDePontoDTO other = (BatedorDePontoDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BatedorDePontoDTO [id=" + id + ", horarioEntrada=" + horarioEntrada + ", horarioSaida=" + horarioSaida
				+ ", dataDoMes=" + dataDoMes + ", dataDaFalta=" + dataDaFalta + ", pontos=" + pontos + ", teveFalta="
				+ teveFalta + "]";
	}
	
	
	
	
}
