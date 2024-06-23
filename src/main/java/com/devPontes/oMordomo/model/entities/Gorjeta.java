package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_gorjeta")
public class Gorjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Double valor;

	@Column
	private boolean foiPaga;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "gorjetas")
	private Set<Garcom> garcoms;

	public Gorjeta() {

	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public boolean isFoiPaga() {
		return foiPaga;
	}

	public void setFoiPaga(boolean foiPaga) {
		this.foiPaga = foiPaga;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Garcom> getGarcoms() {
		return garcoms;
	}

	public void setGarcoms(Set<Garcom> garcoms) {
		this.garcoms = garcoms;
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
		Gorjeta other = (Gorjeta) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Gorjeta [id=" + id + ", valor=" + valor + ", foiPaga=" + foiPaga + ", garcoms=" + garcoms + "]";
	}

}
