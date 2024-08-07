package com.devPontes.oMordomo.services.impl;

import java.util.ArrayList;
import java.util.Comparator;
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
@Transactional
public class ItemServicesImpl implements ItemServices {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	ComandaRepository comandaRepository;

	@Override
	public ItemDTO registarNovoItem(ItemDTO novoItem) throws Exception { // Tempo total de Execução -> O(1)
		Item item = MyMapper.parseObject(novoItem, Item.class);
		if (item != null) {
			return MyMapper.parseObject(itemRepository.save(item), ItemDTO.class); // Tempo de Execução -> O(1)
		}
		throw new Exception("Não foi possivel inserir novo item no banco!");
	}

	@Override
	public ItemDTO atualizarItem(Long itemExistenteId, ItemDTO updated) throws Exception { // Tempo total de Execução ->
																							// O(1)
		Item itemExistente = itemRepository.findById(itemExistenteId)
				.orElseThrow(() -> new Exception("Item com ID: " + itemExistenteId + " Não encontrado! ")); // Tempo de
																											// Execução
																											// -> O(1)
		itemExistente.setDescrição(updated.getDescrição());
		itemExistente.setImgUrl(updated.getImgUrl());
		itemExistente.setNome(updated.getNome());
		itemExistente.setPreço(updated.getPreço());
		itemExistente.setQuantidade(updated.getQuantidade());
		itemExistente.setTemEmEstoque(updated.getTemEmEstoque());
		return MyMapper.parseObject(itemRepository.save(itemExistente), ItemDTO.class); // Tempo de Execução -> O(1)
	}

	@Override
	public void deletarItem(Long itemId) throws Exception { // Tempo total de Execução -> O(1)
		var itemExistente = itemRepository.findById(itemId)
				.orElseThrow(() -> new Exception("Item não encontrado com o ID:" + itemId));
		itemRepository.delete(itemExistente);
	}

	@Override
	public boolean verificarSeTemEmEstoqueByNome(String nomeProdutoParam) throws Exception {
		return itemRepository.verificarSeTemEmEstoqueByNome(nomeProdutoParam);
	}

	@Override
	public List<ItemDTO> filterByPrecoMaiorOuIgualMedia(Double precoMediaParam) throws Exception {
		var itemsPrecoMedia = itemRepository.filterByPrecoMaiorOuIgualMedia(precoMediaParam);
		return MyMapper.parseListObjects(itemsPrecoMedia, ItemDTO.class);
	}

	@Override
	public List<ItemDTO> findItemsPorNome(String nomeKey, List<Long> itemsIds) throws Exception {
		var items = itemRepository.findAllById(itemsIds);

		if (items.isEmpty())
			throw new Exception("Items não encontrado com os IDS passados");

		items.sort(Comparator.comparing(Item::getNome));

		int indiceBaixo = 0;
		int indiceAlto = items.size() - 1;

		List<ItemDTO> founds = new ArrayList<>();

		while (indiceBaixo < indiceAlto) {
			int indiceMeio = indiceBaixo + (indiceAlto - indiceBaixo) / 2;
			String valorMeio = items.get(indiceMeio).getNome();

			int comparacao = valorMeio.compareTo(nomeKey);

			if (comparacao < 0) {
				indiceBaixo = indiceMeio + 1; // Procurar na metade direita

			} else if (comparacao > 0) {
				indiceAlto = indiceMeio - 1; // Procurar na metade esquerda

			} else {
				founds.add(MyMapper.parseObject(items.get(indiceMeio), ItemDTO.class));
				break;
			}
		}
		return founds;
	}

	@Override
	public List<ItemDTO> findItemsPorPreco(Double precoKey, List<Long> itemsIds) throws Exception {
		var items = itemRepository.findAllById(itemsIds);

		if (items.isEmpty())
			throw new Exception("Items não encontrado com os IDS passados");

		items.sort(Comparator.comparing(Item::getPreço));

		int baixo = 0;
		int alto = items.size() - 1;

		List<ItemDTO> founds = new ArrayList<>();

		while (baixo < alto) {

			int indiceMeio = baixo + (alto - baixo) / 2;
			Double valorMeio = items.get(indiceMeio).getPreço();

			int comparacao = valorMeio.compareTo(precoKey);

			if (comparacao < 0) {
				baixo = indiceMeio + 1;
			} else if (comparacao > 0) {
				alto = indiceMeio - 1;
			} else {
				founds.add(MyMapper.parseObject(items.get(indiceMeio), ItemDTO.class));
				break;
			}

		}

		return founds;

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
