package com.devPontes.oMordomo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.model.dtos.ComandaDTO;
import com.devPontes.oMordomo.model.entities.Comanda;
import com.devPontes.oMordomo.model.enums.StatusMesa;
import com.devPontes.oMordomo.model.mapper.MyMapper;
import com.devPontes.oMordomo.repositories.ComandaRepository;
import com.devPontes.oMordomo.repositories.GarcomRepository;
import com.devPontes.oMordomo.repositories.ItemRepository;
import com.devPontes.oMordomo.repositories.MesaRepository;
import com.devPontes.oMordomo.services.ComandaServices;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComandaServicesImpl implements ComandaServices {
	
	@Autowired
	private ComandaRepository comandaRepository;
	
	@Autowired
	private GarcomRepository garcomRepository;
	
	@Autowired
	private MesaRepository mesaRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public ComandaDTO abrirComanda(ComandaDTO novaComanda, Long mesaId, Long garcomId) throws Exception {
		Comanda newComanda = MyMapper.parseObject(novaComanda, Comanda.class);
		var mesa = mesaRepository.findById(mesaId);
		var garcom = garcomRepository.findById(garcomId);
		if(mesa.isPresent() && garcom.isPresent()) {
			newComanda.setDiaPedido(novaComanda.getDiaPedido());
			newComanda.setGarcomComanda(garcom.get());
			newComanda.setMesa(mesa.get());
			mesa.get().setStatusMesa(StatusMesa.OCUPADA);
			newComanda.setEstaFechada(false);
			var entidade = MyMapper.parseObject(newComanda, ComandaDTO.class);
			return entidade;
		} 
		throw new Exception("Não foi possivel abrir uma comanda, verifique os dados e tente novamente!");
	}

	@Override
	@Transactional
    public void adicionarItemNaComanda(Long itemId, Long comandaId) throws Exception {
        var item = itemRepository.findById(itemId).orElseThrow(() -> new Exception("Item não encontrado"));
        var comanda = comandaRepository.findById(comandaId).orElseThrow(() -> new Exception("Comanda não encontrada"));
        if (comanda.isEstaFechada()) {
            throw new Exception("Comanda está fechada, não foi possível adicionar o item!");
        }
        comanda.getItems().add(item);
        comandaRepository.save(comanda);
    }

	@Override
	public void removerItemDaComanda(Long mesaId, Long itemId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ComandaDTO fecharComanda(Long comandaId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calcularSubTotal(Long comandaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calcularTotal(Long comandaId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
	
	