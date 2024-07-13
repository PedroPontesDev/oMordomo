package com.devPontes.oMordomo.services.impl;

import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.model.dtos.ComandaDTO;
import com.devPontes.oMordomo.services.ComandaServices;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComandaServicesImpl implements ComandaServices {

	@Override
	public ComandaDTO abrirComanda(Long mesaId) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
	
	