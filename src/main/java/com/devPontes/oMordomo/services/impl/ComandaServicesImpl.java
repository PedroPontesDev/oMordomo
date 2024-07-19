package com.devPontes.oMordomo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.model.dtos.ComandaDTO;
import com.devPontes.oMordomo.model.entities.Comanda;
import com.devPontes.oMordomo.model.mapper.MyMapper;
import com.devPontes.oMordomo.repositories.ComandaRepository;
import com.devPontes.oMordomo.repositories.GarcomRepository;
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

	@Override
	public ComandaDTO abrirComanda(ComandaDTO novaComanda, Long mesaId, Long garcomId) throws Exception {
		Comanda newComanda = MyMapper.parseObject(novaComanda, Comanda.class);
		var mesa = mesaRepository.findById(mesaId);
		var garcom = garcomRepository.findById(garcomId);
		if(mesa.isPresent() && garcom.isPresent()) {
			newComanda.setDiaPedido(novaComanda.getDiaPedido());
			newComanda.setGarcomComanda(garcom.get());
			newComanda.setMesa(null);
			newComanda.setNotaAtendimento(null);
			
		} //Estou aqui

	}

	@Override
	public void adicionarItemNaComanda(Long mesaId, Long itemId, Long comandaId) throws Exception {
		// TODO Auto-generated method stub
		
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
	
	