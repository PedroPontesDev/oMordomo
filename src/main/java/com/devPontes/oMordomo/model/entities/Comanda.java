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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

	@Column(name = "nota_atendimento")
	private Integer[] notaAtendimento = new Integer[5];
	
	@ManyToOne
	@JoinColumn(name = "garcom_id")
	Garcom garcomComanda;

	@OneToOne
	@JoinColumn(name = "cliente_id")
	Cliente clienteComanda;

	@OneToOne
	@JoinColumn(name = "mesa_id")
	Mesa mesa;
	
	
	@OneToMany(mappedBy = "comanda", fetch = FetchType.EAGER)
	private List<Item> items = new ArrayList<>();
	

	public Comanda(Long id, Double subTotal, Double total, LocalDate diaPedido, Integer[] notaAtendimento,
			Garcom garcomComanda, Cliente clienteComanda, Mesa mesa, List<Item> items) {
		this.id = id;
		this.subTotal = subTotal;
		this.total = total;
		this.diaPedido = diaPedido;
		this.notaAtendimento = notaAtendimento;
		this.garcomComanda = garcomComanda;
		this.clienteComanda = clienteComanda;
		this.mesa = mesa;
		this.items = items;
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
	
	public Integer[] getNotaAtendimento() {
		return notaAtendimento;
	}

	public void setNotaAtendimento(Integer[] notaAtendimento) {
		this.notaAtendimento = notaAtendimento;
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
