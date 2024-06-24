package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
	private BigDecimal horasTrabalhadasMes;

	@Column(name = "houve_falta_mes")
	private Boolean teveFalta;
	
	@OneToMany
	private BatedorDePonto batedorPonto;

	public Garcom(String fullName, String email, String username, String password, Long cpf, Double salario,
			BigDecimal horasTrabalhadasMes, Boolean teveFalta, BatedorDePonto batedorPonto) {
		super(fullName, email, username, password, cpf);
		this.salario = salario;
		this.horasTrabalhadasMes = horasTrabalhadasMes;
		this.teveFalta = teveFalta;
		this.batedorPonto = batedorPonto;
	}

	public Garcom() {

	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public BigDecimal getHorasTrabalhadasMes() {
		return horasTrabalhadasMes;
	}

	public void setHorasTrabalhadasMes(BigDecimal horasTrabalhadasMes) {
		this.horasTrabalhadasMes = horasTrabalhadasMes;
	}

	public Boolean getTeveFalta() {
		return teveFalta;
	}

	public void setTeveFalta(Boolean teveFalta) {
		this.teveFalta = teveFalta;
	}
	
	

	public BatedorDePonto getBatedorPonto() {
		return batedorPonto;
	}

	public void setBatedorPonto(BatedorDePonto batedorPonto) {
		this.batedorPonto = batedorPonto;
	}

	@Override
	public String toString() {
		return "Garcom [salario=" + salario + ", horasTrabalhadasMes=" + horasTrabalhadasMes + ", teveFalta="
				+ teveFalta + "";
	}

}
