package com.devPontes.oMordomo.services;

import java.time.LocalDateTime;
import java.util.List;

import com.devPontes.oMordomo.model.dtos.ComandaDTO;
import com.devPontes.oMordomo.model.dtos.MesaDTO;
import com.devPontes.oMordomo.model.enums.StatusMesa;

public interface MesaServices {
	
	List<MesaDTO> exibirTodasMesas();
	
	MesaDTO exibirMesaPorIdentificador(Long id);
	
	MesaDTO registrarNovaMesa(MesaDTO mesaDTO);
	
	MesaDTO atualizarMesa(Long mesaExistenteId, MesaDTO update);
	
	MesaDTO visualizarEstadoMesa(Long mesaId, String statusMesa);
	
	MesaDTO atualizarEstadoDeMesa(String status, StatusMesa statusMesa, Long mesaId);
	
	void ocuparMesa(Long mesaId, String statusMesa);
	
	void registrarHistoricoDeOcupacao(Long mesaId, LocalDateTime horarioInicio, LocalDateTime horarioFim);
	
	ComandaDTO abrirComanda(Long mesaId);
	
	void adicionarItemNaComanda(Long mesaId, Long itemId, Long comandaId);
	
	void removerItemDaComanda(Long mesaId, Long itemId);
	
	ComandaDTO fecharComanda(Long comandaId);
	
	void excluirMesa(Long mesaId);
	
	// Método para adicionar uma lista de itens na comanda
	void adicionarItensNaComanda(Long mesaId, List<Long> itemDTOIds);
}
