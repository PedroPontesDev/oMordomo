package com.devPontes.oMordomo.services;

import java.util.List;

import com.devPontes.oMordomo.model.dtos.ComandaDTO;

public interface ComandaServices {

	ComandaDTO abrirComanda(ComandaDTO novaComanda, Long mesaId, Long garcomId) throws Exception; //Tempo De Execução -> O(1)

	ComandaDTO fecharComanda(Long comandaId) throws Exception; //Tempo De Execução -> O(1)

	void adicionarItemNaComanda(Long itemId, Long comandaId) throws Exception; ////Tempo de execução -> O(1) 

	void removerItemDaComanda(Long comandaId) throws Exception; //Tempo de Excecução -> O(n) 

	void adicionarMultiplosItemsComanda(List<Long> itemsId, Long comandaId) throws Exception; //Tempo de Excecução -> O(n) 

	Double calcularSubTotal(Long comandaId);

	Double calcularTotal(Long comandaId);

}
