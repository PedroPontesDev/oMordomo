package com.devPontes.oMordomo.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.model.dtos.ComandaDTO;
import com.devPontes.oMordomo.model.dtos.GarcomDTO;
import com.devPontes.oMordomo.model.dtos.ItemDTO;
import com.devPontes.oMordomo.model.dtos.MesaDTO;
import com.devPontes.oMordomo.model.entities.Comanda;
import com.devPontes.oMordomo.model.entities.Garcom;
import com.devPontes.oMordomo.model.entities.Ponto;
import com.devPontes.oMordomo.model.enums.StatusMesa;
import com.devPontes.oMordomo.model.mapper.MyMapper;
import com.devPontes.oMordomo.repositories.GarcomRepository;
import com.devPontes.oMordomo.repositories.PontoRepository;
import com.devPontes.oMordomo.services.GarcomServices;
import com.devPontes.oMordomo.services.ItemServices;
import com.devPontes.oMordomo.services.MesaServices;

import jakarta.transaction.Transactional;

@Service
public class ItemServicesImpl implements ItemServices {

	@Override
	public ItemDTO registarNovoItem(ItemDTO novoItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDTO atualizarItem(Long itemExistenteId, ItemDTO updated) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarItem(Long itemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ItemDTO> filterByPrecoMaiorOuIgualMedia(Double precoMedia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDTO> findItemsPorNome(String nome, List<ItemDTO> items) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDTO> findItemsPorPreco(Double preco, List<ItemDTO> items) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDTO> sortSelectionItemsPorNome(String nome, List<ItemDTO> items) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDTO> sortSelectionItemsPorPreco(Double preco, List<ItemDTO> items) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
	
	