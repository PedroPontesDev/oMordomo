package com.devPontes.oMordomo.model.dtos;

import java.util.Objects;

public class ItemDTO {

    private Long id;
    private String nome;
    private String imgUrl;
    private String descrição;
    private Double preço;
    private Integer quantidade;
    private Boolean temEmEstoque;
    
	public ItemDTO(Long id, String nome, String imgUrl, String descrição, Double preço, Integer quantidade,
			Boolean temEmEstoque) {
		this.id = id;
		this.nome = nome;
		this.imgUrl = imgUrl;
		this.descrição = descrição;
		this.preço = preço;
		this.quantidade = quantidade;
		this.temEmEstoque = temEmEstoque;
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
		ItemDTO other = (ItemDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ItemDTO [id=" + id + ", nome=" + nome + ", imgUrl=" + imgUrl + ", descrição=" + descrição + ", preço="
				+ preço + ", quantidade=" + quantidade + ", temEmEstoque=" + temEmEstoque + "]";
	}

	
   
}
