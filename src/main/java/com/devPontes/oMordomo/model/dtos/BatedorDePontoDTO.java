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

@JsonPropertyOrder("id, pontos, teveFaltaMes")
public class BatedorDePontoDTO extends RepresentationModel<BatedorDePontoDTO> {

	private Long id;

	private String nome;

	@JsonFormat(pattern = "yyyy/MM/dd", shape = Shape.STRING)
	@JsonProperty(value = "dataMesFalta")
	private LocalDate dataDoMes;

	private List<PontoDTO> pontos = new ArrayList<>();

	private Boolean houveFalta;

	public BatedorDePontoDTO(Long id, String nome, LocalDate dataDoMes, List<PontoDTO> pontos, Boolean houveFalta) {
		this.id = id;
		this.nome = nome;
		this.dataDoMes = dataDoMes;
		this.pontos = pontos;
		this.houveFalta = houveFalta;
	}

	public BatedorDePontoDTO() {
		
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDoMes() {
		return dataDoMes;
	}

	public void setDataDoMes(LocalDate dataDoMes) {
		this.dataDoMes = dataDoMes;
	}

	public List<PontoDTO> getPontos() {
		return pontos;
	}

	public void setPontos(List<PontoDTO> pontos) {
		this.pontos = pontos;
	}

	public Boolean getHouveFalta() {
		return houveFalta;
	}

	public void setHouveFalta(Boolean houveFalta) {
		this.houveFalta = houveFalta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataDoMes, houveFalta, id, nome, pontos);
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
		return Objects.equals(dataDoMes, other.dataDoMes) && Objects.equals(houveFalta, other.houveFalta)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(pontos, other.pontos);
	}

	@Override
	public String toString() {
		return "BatedorDePontoDTO [id=" + id + ", nome=" + nome + ", dataDoMes=" + dataDoMes + ", pontos=" + pontos
				+ ", houveFalta=" + houveFalta + "]";
	}
	
	
	

	

}	
