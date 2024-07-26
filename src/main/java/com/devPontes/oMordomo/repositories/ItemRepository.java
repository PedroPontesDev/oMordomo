package com.devPontes.oMordomo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devPontes.oMordomo.model.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	@Query(value = "SELECT * FROM tb_item WHERE preco >= :precoMedia", nativeQuery = true)
	public List<Item> filterByPrecoMaiorOuIgualMedia(@Param("precoMedia") Double precoMedia); //Primeiro metodo de ItemsServices feito por Query


	
}
