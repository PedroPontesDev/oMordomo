package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_batedor_ponto")
public class BatedorDePonto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_batedor_ponto")
	private String nomeBatedor;

	@Column(name = "data_falta_mes")
	private LocalDate dataDoMes;

	@OneToMany(mappedBy = "batedorDePonto", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Ponto> pontos = new ArrayList<>();

	@Column(name = "houve_falta_mes")
	private Boolean houveFalta;

	public BatedorDePonto(Long id, LocalDate dataDoMes, LocalDate dataFalta, List<Ponto> pontos, Boolean houveFalta,
			String nomeBatedor) {
		this.id = id;
		this.dataDoMes = dataDoMes;
		this.pontos = pontos;
		this.houveFalta = houveFalta;
		this.nomeBatedor = nomeBatedor;

	}

	public BatedorDePonto() {

	}

	public String getNomeBatedor() {
		return nomeBatedor;
	}

	public void setNomeBatedor(String nomeBatedor) {
		this.nomeBatedor = nomeBatedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getHouveFalta() {
		return houveFalta;
	}

	public void setHouveFalta(Boolean houveFalta) {
		this.houveFalta = houveFalta;
	}

	public List<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}

	public LocalDate getdataDoMes() {
		return dataDoMes;
	}

	public void setdataDoMes(LocalDate dataDoMes) {
		this.dataDoMes = dataDoMes;
	}

	public LocalDate getDataDoMes() {
		return dataDoMes;
	}

	public void setDataDoMes(LocalDate dataDoMes) {
		this.dataDoMes = dataDoMes;
	}

	public Long calcularTotalDeHorasTrabalhadasMes(Garcom garcom) {
		var calculo = pontos.stream().filter(p -> p.getGarcom().equals(garcom))
				.filter(p -> p.getHorarioEntrada().getMonth().equals(this.dataDoMes.getMonth()))
				.mapToLong(p -> Duration.between(p.getHorarioEntrada(), p.getHorarioSaida()).toHours()).sum();
		garcom.setHorasTrabalhadasMes(calculo);
		return calculo;
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
		BatedorDePonto other = (BatedorDePonto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BatedorDePonto [id=" + id + ", nomeBatedor=" + nomeBatedor + ", dataDoMes=" + dataDoMes + ", pontos="
				+ pontos + ", houveFalta=" + houveFalta + "]";
	}

	
}
