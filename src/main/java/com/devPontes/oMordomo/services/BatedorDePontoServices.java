package com.devPontes.oMordomo.services;

import com.devPontes.oMordomo.model.dtos.ComandaDTO;
import com.devPontes.oMordomo.model.dtos.GarcomDTO;
import com.devPontes.oMordomo.model.dtos.PontoDTO;
import com.devPontes.oMordomo.model.entities.BatedorDePonto;

public interface BatedorDePontoServices {
	
	void atrelaGarcomComanda(Long garcomId, Long comandaId) throws Exception;
	BatedorDePonto RegistrarPonto(PontoDTO ponto) throws Exception;
	GarcomDTO procurarPorCpf(Long cpf) throws Exception;
	GarcomDTO registrarNovoGarcom(GarcomDTO novoGarcom) throws Exception;
	GarcomDTO atualizarGarcomExistente(Long garcomId, GarcomDTO update) throws Exception;
	GarcomDTO alterarSalarioGarcom(Long garcomId, Double novoSalario) throws Exception;
	ComandaDTO abrirNovaComanda(ComandaDTO abrirComanda) throws Exception; 
	ComandaDTO fecharComanda(Long comandaId) throws Exception;
	void deletarGarcomExistente(Long garcomId) throws Exception;
	
	//Criar depois a entidade ITEM para incluir na entidade de Comanda
	
}
