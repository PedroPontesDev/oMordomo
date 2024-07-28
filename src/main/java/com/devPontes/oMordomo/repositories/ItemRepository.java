package com.devPontes.oMordomo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devPontes.oMordomo.model.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	@Query(value = "SELECT * FROM tb_item WHERE preco >= :precoMedia OR preco <= :precoMedia", nativeQuery = true)
	public List<Item> filterByPrecoMaiorOuIgualMedia(@Param("precoMedia") Double precoMedia); //Primeiro metodo de ItemsServices feito por Query Params
	
	@Query(value = "SELECT CASE WEHN COUNT(i) > 0 THEN TRUE ELSE FALSE END" 
												+ "FROM Item i WHERE i.nome = :nomeProduto AND i.quantidade > 0" , nativeQuery = false)
	public boolean verificarSeTemEmEstoqueByNome(@Param("nomeProduto") String nomeProduto); 

	
}
