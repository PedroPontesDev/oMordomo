package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_garcom")
@PrimaryKeyJoinColumn(name = "usuario.id")
@DiscriminatorValue("GARCOM")
public class Garcom extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(length = 90, nullable = false)
	private Double salario;

	@Column(name = "total_horas_trabalhadas")
	private Long horasTrabalhadasMes;

	@OneToMany(mappedBy = "garcom", cascade = CascadeType.ALL)
	private List<Ponto> pontos = new ArrayList<>();

	@Column(name = "teve_falta")
	private Boolean teveFalta;

	// A implementar relação com Comandas

	public Garcom() {

	}

	public Garcom(Long id, String fullName, String email, String username, String password, Long cpf, Double salario,
			Long horasTrabalhadasMes, List<Ponto> pontos, Boolean teveFalta) {
		super(id, fullName, email, username, password, cpf);
		this.salario = salario;
		this.horasTrabalhadasMes = horasTrabalhadasMes;
		this.pontos = pontos;
		this.teveFalta = teveFalta;
	}

	public List<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public Boolean getTeveFalta() {
		return teveFalta;
	}

	public void setTeveFalta(Boolean teveFalta) {
		this.teveFalta = teveFalta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(horasTrabalhadasMes, id, pontos, salario, teveFalta);
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
		return Objects.equals(horasTrabalhadasMes, other.horasTrabalhadasMes) && Objects.equals(id, other.id)
				&& Objects.equals(pontos, other.pontos) && Objects.equals(salario, other.salario)
				&& Objects.equals(teveFalta, other.teveFalta);
	}

	@Override
	public String toString() {
		return "Garcom [id=" + id + ", salario=" + salario + ", horasTrabalhadasMes=" + horasTrabalhadasMes
				+ ", teveFalta=" + teveFalta + "]";
	}

	

}
