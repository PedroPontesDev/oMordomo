package com.devPontes.oMordomo.services;

import com.devPontes.oMordomo.model.dtos.ComandaDTO;

public interface ComandaServices {

	ComandaDTO abrirComanda(ComandaDTO novaComanda, Long mesaId, Long garcomId) throws Exception;

	void adicionarItemNaComanda(Long itemId, Long comandaId) throws Exception;
	
	void removerItemDaComanda(Long mesaId, Long itemId)throws Exception;
	
	ComandaDTO fecharComanda(Long comandaId)throws Exception;
	
	Double calcularSubTotal(Long comandaId);
	
	Double calcularTotal(Long comandaId);

	
}
