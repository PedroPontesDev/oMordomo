package com.devPontes.oMordomo.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.devPontes.oMordomo.model.dtos.ItemDTO;
import com.devPontes.oMordomo.model.entities.Item;

public interface ItemServices {

	public ItemDTO registarNovoItem(ItemDTO novoItem); //Tempo de execucao -> O(1)
	
	public ItemDTO atualizarItem(Long itemExistenteId, ItemDTO updated); //Tempo de execucao -> O(1)
	
	public void deletarItem(Long itemId); //Tempo de execucao -> O(1)
	
	public List<ItemDTO> filterByPrecoMaiorOuIgualMedia(@Param("precoMedia") Double precoMedia);
	
	public List<ItemDTO> findItemsPorNome(String nome, List<ItemDTO> items); // Tempo de execucao -> O(log n) Pesquisa Binária 
	
	public List<ItemDTO> findItemsPorPreco(Double preco, List<ItemDTO> items); // Tempo de execucao -> O(log n) Pesquisa Binária 
	
	public List<ItemDTO> sortSelectionItemsPorNome(String nome, List<ItemDTO> items); //Tempo de execução -> O(n²) porque percorrre duas vezes
	
	public List<ItemDTO> sortSelectionItemsPorPreco(Double preco, List<ItemDTO> items); //Tempo de execução -> O(n²) porque percorrre duas vezes 
	
}
