package com.devPontes.oMordomo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.model.dtos.ItemDTO;
import com.devPontes.oMordomo.model.entities.Item;
import com.devPontes.oMordomo.model.mapper.MyMapper;
import com.devPontes.oMordomo.repositories.ComandaRepository;
import com.devPontes.oMordomo.repositories.ItemRepository;
import com.devPontes.oMordomo.services.ItemServices;

import jakarta.transaction.Transactional;

@Service
@Transactional(rollbackOn = ItemServicesImpl.class)
public class ItemServicesImpl implements ItemServices {

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ComandaRepository comandaRepository;

	@Override
	public ItemDTO registarNovoItem(ItemDTO novoItem) throws Exception { //Tempo total de Execução -> O(1)
		Item item = MyMapper.parseObject(novoItem, Item.class);
		if(item != null) {
			return MyMapper.parseObject(itemRepository.save(item), ItemDTO.class);  //Tempo de Execução -> O(1)
		} throw new Exception("Não foi possivel inserir novo item no banco!");
	}

	@Override
	public ItemDTO atualizarItem(Long itemExistenteId, ItemDTO updated) throws Exception { //Tempo total de Execução -> O(1)
		Item itemExistente = itemRepository.findById(itemExistenteId)
					.orElseThrow(() -> new Exception("Item com ID: " + itemExistenteId + " Não encontrado! ")); //Tempo de Execução -> O(1)
		itemExistente.setDescrição(updated.getDescrição());
		itemExistente.setImgUrl(updated.getImgUrl());
		itemExistente.setNome(updated.getNome());
		itemExistente.setPreço(updated.getPreço());
		itemExistente.setQuantidade(updated.getQuantidade());
		itemExistente.setTemEmEstoque(updated.getTemEmEstoque());
		return MyMapper.parseObject(itemRepository.save(itemExistente), ItemDTO.class); //Tempo de Execução -> O(1)		
	}

	@Override
	public void deletarItem(Long itemId) throws Exception { //Tempo total de Execução -> O(1)
		var itemExistente = itemRepository.findById(itemId)
				.orElseThrow(() -> new Exception("Item não encontrado com o ID:" + itemId));
		itemRepository.delete(itemExistente);
	}

	@Override
	public boolean verificarSeTemEmEstoqueByNome(String nomeProdutoParam) throws Exception {
		if(nomeProdutoParam.matches("[0-9][+-]")) throw new Exception("Um nome pessoal não pode conter numeros!");
		return itemRepository.verificarSeTemEmEstoqueByNome(nomeProdutoParam);
	}

	@Override
	public List<ItemDTO> filterByPrecoMaiorOuIgualMedia(Double precoMediaParam) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDTO> findItemsPorNome(String nomeKey, List<ItemDTO> items) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDTO> findItemsPorPreco(Double preco, List<ItemDTO> items) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDTO> sortSelectionItemsPorNome(List<ItemDTO> items) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDTO> sortSelectionItemsPorPreco(List<ItemDTO> items) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
	
	