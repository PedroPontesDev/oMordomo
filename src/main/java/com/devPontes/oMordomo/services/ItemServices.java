package com.devPontes.oMordomo.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.devPontes.oMordomo.model.dtos.ItemDTO;
import com.devPontes.oMordomo.model.entities.Item;

public interface ItemServices {

	public ItemDTO registarNovoItem(ItemDTO novoItem) throws Exception; //Tempo de execucao -> O(1)
	
	public ItemDTO atualizarItem(Long itemExistenteId, ItemDTO updated) throws Exception; //Tempo de execucao -> O(1)
	
	public void deletarItem(Long itemId) throws Exception; //Tempo de execucao -> O(1)
	
	public boolean verificarSeTemEmEstoqueByNome(String nomeProdutoParam) throws Exception; //Tempo de Execução -> O(1)
	
	public List<ItemDTO> filterByPrecoMaiorOuIgualMedia(Double precoMediaParam) throws Exception; //QueryParam Consulta De Filtro com Tempo de Execução -> O(1)
	
	public List<ItemDTO> findItemsPorNome(String nomeKey, List<Long> itemsIds) throws Exception; // Tempo de execucao -> O(log n) Pesquisa Binária 
	
	public List<ItemDTO> findItemsPorPreco(Double precoKey, List<Long> itemsIds) throws Exception; // Tempo de execucao -> O(log n) Pesquisa Binária 
	
	public List<ItemDTO> sortSelectionItemsPorNome(List<ItemDTO> items) throws Exception; //Tempo de execução -> O(n²) porque percorrre duas vezes
	
	public List<ItemDTO> sortSelectionItemsPorPreco(List<ItemDTO> items) throws Exception; //Tempo de execução -> O(n²) porque percorrre duas vezes 
	
}
