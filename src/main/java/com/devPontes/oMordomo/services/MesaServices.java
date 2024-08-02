package com.devPontes.oMordomo.services;

import java.time.LocalDateTime;
import java.util.List;

import com.devPontes.oMordomo.model.dtos.ComandaDTO;
import com.devPontes.oMordomo.model.dtos.MesaDTO;
import com.devPontes.oMordomo.model.enums.StatusMesa;

public interface MesaServices {
	
	List<MesaDTO> exibirTodasMesas() throws Exception;
	
	MesaDTO exibirMesaPorIdentificador(Long id) throws Exception;
	
	MesaDTO registrarNovaMesa(MesaDTO mesaDTO) throws Exception;
	
	MesaDTO atualizarMesa(Long mesaExistenteId, MesaDTO update) throws Exception;
	
	MesaDTO visualizarEstadoMesa(Long mesaId, String statusMesa) throws Exception;
	
	MesaDTO atualizarEstadoDeMesa(String status, StatusMesa statusMesa, Long mesaId) throws Exception;
	
	void ocuparMesa(Long mesaId, String statusMesa, Long comandaId) throws Exception;
	
	void excluirMesa(Long mesaId);
	
	// Método para adicionar uma lista de itens na comanda
	void adicionarItensNaComanda(Long mesaId, List<Long> itemDTOIds);
}
