package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Column(name = "nome")
	private String nomeBatedor;

	@Column(name = "horario_entrada")
	private LocalDateTime horarioEntrada;

	@Column(name = "horario_saida")
	private LocalDateTime horarioSaida;

	@Column(name = "data")
	private LocalDate dataDoMes;

	@Column(name = "dia_falta")
	private LocalDate dataDaFalta;

	@JsonIgnore
	@OneToMany(mappedBy = "batedorDePonto", fetch = FetchType.LAZY)
	private List<Ponto> pontos = new ArrayList<>();

	@Column(name = "houve_falta_mes")
	private Boolean teveFalta;

	public BatedorDePonto(Long id, LocalDateTime horarioEntrada, LocalDateTime horarioSaida, LocalDate dataDoMes,
			LocalDate dataFalta, List<Ponto> pontos, Boolean teveFalta, String nomeBatedor) {
		this.id = id;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.dataDoMes = dataDoMes;
		this.dataDaFalta = dataFalta;
		this.pontos = pontos;
		this.teveFalta = teveFalta;
		this.nomeBatedor = nomeBatedor;
	}

	public BatedorDePonto() {

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

	public LocalDate getDataDaFalta() {
		return dataDaFalta;
	}

	public void setDataFalta(LocalDate dataFalta) {
		this.dataDaFalta = dataFalta;
	}

	public Boolean getTeveFalta() {
		return teveFalta;
	}

	public void setTeveFalta(Boolean teveFalta) {
		this.teveFalta = teveFalta;
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

	public String getNomeBatedor() {
		return nomeBatedor;
	}

	public void setNomeBatedor(String nomeBatedor) {
		this.nomeBatedor = nomeBatedor;
	}

	public LocalDate getDataDoMes() {
		return dataDoMes;
	}

	public void setDataDoMes(LocalDate dataDoMes) {
		this.dataDoMes = dataDoMes;
	}

	public void setDataDaFalta(LocalDate dataDaFalta) {
		this.dataDaFalta = dataDaFalta;
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
		return "BatedorDePonto [id=" + id + ", horarioEntrada=" + horarioEntrada + ", horarioSaida=" + horarioSaida
				+ ", dataDoMes=" + dataDoMes + ", dataDaFalta=" + dataDaFalta + ", pontos=" + pontos + ", teveFalta="
				+ teveFalta + "]";
	}

}
