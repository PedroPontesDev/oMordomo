package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_garcom")
@PrimaryKeyJoinColumn(name = "usuario.id")
@DiscriminatorValue("GARCOM")
public class Garcom extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
		
	@Column(length = 90, nullable = false)
	private Double salario;
	
	@Column(name = "total_horas_trabalhadas")
	private LocalDateTime horasTrabalhadasMes;
	
	@Column(name = "houve_falta")
	private Boolean teveFalta;


	public Garcom(String fullName, String email, String username, String password, Long cpf, Double salario,
			LocalDateTime horasTrabalhadasMes, Boolean teveFalta) {
		super(fullName, email, username, password, cpf);
		this.salario = salario;
		this.horasTrabalhadasMes = horasTrabalhadasMes;
		this.teveFalta = teveFalta;
	}

	public Garcom() {

	}

	

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public LocalDateTime getHorasTrabalhadasMes() {
		return horasTrabalhadasMes;
	}

	public void setHorasTrabalhadasMes(LocalDateTime horasTrabalhadasMes) {
		this.horasTrabalhadasMes = horasTrabalhadasMes;
	}

	public Boolean getTeveFalta() {
		return teveFalta;
	}

	public void setTeveFalta(Boolean teveFalta) {
		this.teveFalta = teveFalta;
	}



	
	@Override
	public String toString() {
		return "Garcom [salario=" + salario + ", horasTrabalhadasMes=" + horasTrabalhadasMes + ", teveFalta="
				+ teveFalta + "";
	}

	

}
