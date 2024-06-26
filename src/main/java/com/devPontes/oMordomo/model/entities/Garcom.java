package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_garcom")
@PrimaryKeyJoinColumn(name = "usuario.id")
@DiscriminatorValue("GARCOM")
public class Garcom extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 90, nullable = false)
	private Double salario;

	@Column(name = "total_horas_trabalhadas")
	private Long horasTrabalhadasMes;

	@OneToOne
	private Ponto pontoGarcom;

	public Garcom(String fullName, String email, String username, String password, Long cpf, Double salario,
			Long horasTrabalhadasMes, Ponto ponto) {
		super(fullName, email, username, password, cpf);
		this.salario = salario;
		this.horasTrabalhadasMes = horasTrabalhadasMes;
		this.pontoGarcom = ponto;
	}

	public Garcom() {

	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Long getHorasTrabalhadasMes() {
		return horasTrabalhadasMes;
	}

	public void setHorasTrabalhadasMes(Long horasTrabalhadasMes) {
		this.horasTrabalhadasMes = horasTrabalhadasMes;
	}

	public Ponto getPontoGarcom() {
		return pontoGarcom;
	}

	public void setPontoGarcom(Ponto pontoGarcom) {
		this.pontoGarcom = pontoGarcom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(horasTrabalhadasMes, pontoGarcom, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Garcom other = (Garcom) obj;
		return Objects.equals(horasTrabalhadasMes, other.horasTrabalhadasMes)
				&& Objects.equals(pontoGarcom, other.pontoGarcom) && Objects.equals(salario, other.salario);
	}

	@Override
	public String toString() {
		return "Garcom [salario=" + salario + ", horasTrabalhadasMes=" + horasTrabalhadasMes + ", pontoGarcom="
				+ pontoGarcom + "]";
	}

}
