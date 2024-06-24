package com.devPontes.oMordomo.services;

import java.util.List;

import com.devPontes.oMordomo.model.dtos.ComandaDTO;
import com.devPontes.oMordomo.model.dtos.GarcomDTO;

public interface BatedorDePontoServices {
	
	List<GarcomDTO> listarTodos() throws Exception;
	GarcomDTO procurarPorId(Long id) throws Exception;
	GarcomDTO procurarPorCpf(Long cpf) throws Exception;
	GarcomDTO registrarNovoGarcom(GarcomDTO novoGarcom) throws Exception;
	GarcomDTO atualizarGarcomExistente(Long garcomId, GarcomDTO update) throws Exception;
	GarcomDTO alterarSalarioGarcom(Long garcomId, Double novoSalario) throws Exception;
	ComandaDTO abrirNovaComanda(ComandaDTO abrirComanda) throws Exception; 
	ComandaDTO fecharComanda(Long comandaId) throws Exception;
	void deletarGarcomExistente(Long garcomId) throws Exception;
	
	//Criar depois a entidade ITEM para incluir na entidade de Comanda
	
}
