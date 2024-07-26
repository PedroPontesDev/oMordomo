package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_comanda")
public class Comanda implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "sub_total")
	private Double subTotal;

	@Column
	private Double total;

	@Column(name = "dia_pedido")
	private LocalDate diaPedido;

	@ManyToMany(mappedBy = "comandas")
	private Set<Item> items = new TreeSet<>();

	@ManyToOne
	@JoinColumn(name = "garcom_id")
	private Garcom garcomComanda;

	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente clienteComanda;

	@OneToOne
	@JoinColumn(name = "mesa_id")
	private Mesa mesa;

	private boolean estaFechada;

	public Comanda(Long id, Double subTotal, Double total, LocalDate diaPedido, Garcom garcomComanda,
			Cliente clienteComanda, Mesa mesa, Set<Item> items, boolean estaFechada) {
		this.id = id;
		this.subTotal = subTotal;
		this.total = total;
		this.diaPedido = diaPedido;
		this.garcomComanda = garcomComanda;
		this.clienteComanda = clienteComanda;
		this.mesa = mesa;
		this.items = items;
		this.estaFechada = estaFechada;
	}

	public Comanda() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Item> getItems() {
		return items;
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

	public Garcom getGarcomComanda() {
		return garcomComanda;
	}

	public void setGarcomComanda(Garcom garcomComanda) {
		this.garcomComanda = garcomComanda;
	}

	public Cliente getClienteComanda() {
		return clienteComanda;
	}

	public void setClienteComanda(Cliente clienteComanda) {
		this.clienteComanda = clienteComanda;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public boolean isEstaFechada() {
		return estaFechada;
	}

	public void setEstaFechada(boolean estaFechada) {
		this.estaFechada = estaFechada;
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
		return "Comanda [id=" + id + ", subTotal=" + subTotal + ", total=" + total + ", diaPedido=" + diaPedido
				+ ", items=" + items + ", garcomComanda=" + garcomComanda + ", clienteComanda=" + clienteComanda
				+ ", mesa=" + mesa + ", estaFechada=" + estaFechada + "]";
	}

}
