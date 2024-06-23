package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_garcom")
@PrimaryKeyJoinColumn(name = "usuario.id")
public class BatedorDePonto extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
		
	@Column(length = 90, nullable = false)
	private Double salario;
	
	@Column
	private LocalDateTime horasTrabalhadasMes;
	
	@Column
	private Boolean teveFalta;

	@ManyToMany
	@JoinTable(name = "tb_gorjeta_garcom", joinColumns = @JoinColumn(name = "garcom_id"),
	inverseJoinColumns = @JoinColumn(name = "gorjeta_id"))
	private Set<Gorjeta> gorjetas = new TreeSet<>();


	public BatedorDePonto(String fullName, String email, String username, String password, Long cpf, Double salario,
			LocalDateTime horasTrabalhadasMes, Boolean teveFalta, Set<Gorjeta> gorjetas) {
		super(fullName, email, username, password, cpf);
		this.salario = salario;
		this.horasTrabalhadasMes = horasTrabalhadasMes;
		this.teveFalta = teveFalta;
		this.gorjetas = gorjetas;
	}

	public BatedorDePonto() {

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

	public Set<Gorjeta> getGorjetas() {
		return gorjetas;
	}

	public void setGorjetas(Set<Gorjeta> gorjetas) {
		this.gorjetas = gorjetas;
	}

	
	
	@Override
	public String toString() {
		return "Garcom [salario=" + salario + ", horasTrabalhadasMes=" + horasTrabalhadasMes + ", teveFalta="
				+ teveFalta + ", gorjetas=" + gorjetas + "]";
	}

	

}
