package com.devPontes.oMordomo.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany
	@JoinTable(name = "items_de_comanda", joinColumns = @JoinColumn(name = "comanda.id"), inverseJoinColumns = @JoinColumn(name = "items.id"))
	private List<Comanda> comandas = new ArrayList<>();

	public Item(Long id, String nome, String imgUrl, String descrição, Double preço, Integer quantidade,
			Boolean temEmEstoque, List<Comanda> comandas) {
		this.id = id;
		this.nome = nome;
		this.imgUrl = imgUrl;
		this.descrição = descrição;
		this.preço = preço;
		this.quantidade = quantidade;
		this.temEmEstoque = temEmEstoque;
		this.comandas = comandas;
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
		if(quantidade <= 0) {
			return false;
		} return true;
	}
	

	public List<Comanda> getComandas() {
		return comandas;
	}

	public void setTemEmEstoque(Boolean temEmEstoque) {
		this.temEmEstoque = temEmEstoque;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descrição, id, imgUrl, nome, preço, quantidade, temEmEstoque);
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
		return Objects.equals(descrição, other.descrição)
				&& Objects.equals(id, other.id) && Objects.equals(imgUrl, other.imgUrl)
				&& Objects.equals(nome, other.nome) && Objects.equals(preço, other.preço)
				&& Objects.equals(quantidade, other.quantidade) && Objects.equals(temEmEstoque, other.temEmEstoque);
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", imgUrl=" + imgUrl + ", descrição=" + descrição + ", preço="
				+ preço + ", quantidade=" + quantidade + ", temEmEstoque=" + temEmEstoque + "]";
	}
}
