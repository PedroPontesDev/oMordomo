package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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

	@Column(name = "data_ponto")
	private LocalDate dataMes;

	@OneToMany(mappedBy = "batedorPonto", fetch = FetchType.EAGER)
	private List<Garcom> garcoms = new ArrayList<>();

	public BatedorDePonto(Long id, LocalDateTime horarioEntrada, LocalDateTime horarioSaida, List<Garcom> garcoms) {
		this.id = id;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.garcoms = garcoms;
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

	public List<Garcom> getGarcoms() {
		return garcoms;
	}

	public void setGarcoms(List<Garcom> garcoms) {
		this.garcoms = garcoms;
	}

	public Integer totalDeHorasTrabalhadasMes(LocalDateTime horarioEntrada, LocalDateTime horarioSaida,
			LocalDate dataMes) {
		var horaDeEntrada = horarioEntrada.getHour();
		var horarioDeSaida = horarioSaida.getHour();
		var mes = dataMes.getMonthValue();

		Integer totalHoras = (horaDeEntrada + horarioDeSaida) * mes;

		return totalHoras;

	}

}
