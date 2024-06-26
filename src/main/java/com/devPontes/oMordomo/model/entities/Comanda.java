package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_comanda")
public class Comanda implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(fetch = FetchType.EAGER )
	private List<Item> items = new ArrayList<>();
	
	@Column(name = "sub_total")
	private Double subTotal;
	
	@Column
	private Double total;
	
	@Column(name = "dia_pedido")
	private LocalDate diaPedido; 

	//A implementar relação com Garcoms
	
	public Comanda(Long id, List<Item> items, Double subTotal, Double total, LocalDate diaPedido) {
		this.id = id;
		this.items = items;
		this.subTotal = subTotal;
		this.total = total;
		this.diaPedido = diaPedido;
	}


	public Comanda() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	public Double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public LocalDate getDiaPedido() {
		return diaPedido;
	}


	public void setDiaPedido(LocalDate diaPedido) {
		this.diaPedido = diaPedido;
	}


	@Override
	public int hashCode() {
		return Objects.hash(diaPedido, id, items, subTotal, total);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comanda other = (Comanda) obj;
		return Objects.equals(diaPedido, other.diaPedido) && Objects.equals(id, other.id)
				&& Objects.equals(items, other.items) && Objects.equals(subTotal, other.subTotal)
				&& Objects.equals(total, other.total);
	}


	@Override
	public String toString() {
		return "Comanda [id=" + id + ", items=" + items + ", subTotal=" + subTotal + ", total=" + total + ", diaPedido="
				+ diaPedido + "]";
	}


	
	
}
