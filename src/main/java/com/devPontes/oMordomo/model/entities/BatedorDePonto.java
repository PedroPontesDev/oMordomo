package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

	@Column(name = "horario_entrada")
	private LocalDateTime horarioEntrada;

	@Column(name = "horario_saida")
	private LocalDateTime horarioSaida;

	@Column(name = "data")
	private LocalDate dataMes;
	
	@Column(name = "data_falta")
	private LocalDate dataFalta;

	@OneToMany(mappedBy = "batedorDePonto", fetch = FetchType.LAZY)
	private List<Ponto> pontos = new ArrayList<>();

	@Column(name = "houve_falta_mes")
	private Boolean teveFalta;


	
	
	public BatedorDePonto(Long id, LocalDateTime horarioEntrada, LocalDateTime horarioSaida, LocalDate dataMes,
			LocalDate dataFalta, List<Ponto> pontos, Boolean teveFalta) {
		this.id = id;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.dataMes = dataMes;
		this.dataFalta = dataFalta;
		this.pontos = pontos;
		this.teveFalta = teveFalta;
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

	public LocalDate getDataFalta() {
		return dataFalta;
	}

	public void setDataFalta(LocalDate dataFalta) {
		this.dataFalta = dataFalta;
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
	
	

	public LocalDate getDataMes() {
		return dataMes;
	}

	public void setDataMes(LocalDate dataMes) {
		this.dataMes = dataMes;
	}

	public Long calcularTotalDeHorasTrabalhadasMes(Garcom garcom) {
		var calculo = pontos.stream().filter(p -> p.getHorarioEntrada()
				.getMonth().equals(this.dataMes.getMonth()))
				.mapToLong(p -> Duration.between(p.getHorarioEntrada(), p.getHorarioSaida())
						.toHours()).sum();
		garcom.setHorasTrabalhadasMes(calculo);
		return calculo;
	}

}
