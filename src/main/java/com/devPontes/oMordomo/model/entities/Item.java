package com.devPontes.oMordomo.model.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	@Column
	private String imgUrl;
	@Column(name = "descricao")
	private String descrição;
	@Column(name = "preco")
	private Double preço;
	@Column
	private Integer quantidade;
	
	@Column(name = "tem_em_estoque")
	private Boolean temEmEstoque;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Comanda comanda;

	public Item(Long id, String nome, String imgUrl, String descrição, Double preço, Integer quantidade,
			Boolean temEmEstoque, Comanda comanda) {
		super();
		this.id = id;
		this.nome = nome;
		this.imgUrl = imgUrl;
		this.descrição = descrição;
		this.preço = preço;
		this.quantidade = quantidade;
		this.temEmEstoque = temEmEstoque;
		this.comanda = comanda;
	}

	public Item() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public Double getPreço() {
		return preço;
	}

	public void setPreço(Double preço) {
		this.preço = preço;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Boolean getTemEmEstoque() {
		return temEmEstoque;
	}

	public void setTemEmEstoque(Boolean temEmEstoque) {
		this.temEmEstoque = temEmEstoque;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(comanda, descrição, id, imgUrl, nome, preço, quantidade, temEmEstoque);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(comanda, other.comanda) && Objects.equals(descrição, other.descrição)
				&& Objects.equals(id, other.id) && Objects.equals(imgUrl, other.imgUrl)
				&& Objects.equals(nome, other.nome) && Objects.equals(preço, other.preço)
				&& Objects.equals(quantidade, other.quantidade) && Objects.equals(temEmEstoque, other.temEmEstoque);
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", imgUrl=" + imgUrl + ", descrição=" + descrição + ", preço="
				+ preço + ", quantidade=" + quantidade + ", temEmEstoque=" + temEmEstoque + ", comanda=" + comanda
				+ "]";
	}
	
	
	
	
	
	
}
