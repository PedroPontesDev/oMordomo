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
import com.devPontes.oMordomo.model.dtos.MesaDTO;
import com.devPontes.oMordomo.model.entities.Comanda;
import com.devPontes.oMordomo.model.entities.Garcom;
import com.devPontes.oMordomo.model.entities.Ponto;
import com.devPontes.oMordomo.model.enums.StatusMesa;
import com.devPontes.oMordomo.model.mapper.MyMapper;
import com.devPontes.oMordomo.repositories.GarcomRepository;
import com.devPontes.oMordomo.repositories.MesaRepository;
import com.devPontes.oMordomo.repositories.PontoRepository;
import com.devPontes.oMordomo.services.GarcomServices;
import com.devPontes.oMordomo.services.MesaServices;

import jakarta.transaction.Transactional;

@Service
public class MesaServicesImpl implements MesaServices {

	@Autowired
	private MesaRepository mesaRepository;
	
	@Override
	public List<MesaDTO> exibirTodasMesas() throws Exception {
		var todasMesa = mesaRepository.findAll();
		if(!todasMesa.isEmpty()) {
			return MyMapper.parseListObjects(todasMesa, MesaDTO.class);
		} throw new Exception("");
	}

	@Override
	public MesaDTO exibirMesaPorIdentificador(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MesaDTO registrarNovaMesa(MesaDTO mesaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MesaDTO atualizarMesa(Long mesaExistenteId, MesaDTO update) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MesaDTO visualizarEstadoMesa(Long mesaId, String statusMesa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MesaDTO atualizarEstadoDeMesa(String status, StatusMesa statusMesa, Long mesaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ocuparMesa(Long mesaId, String statusMesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarHistoricoDeOcupacao(Long mesaId, LocalDateTime horarioInicio, LocalDateTime horarioFim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ComandaDTO abrirComanda(Long mesaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionarItemNaComanda(Long mesaId, Long itemId, Long comandaId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerItemDaComanda(Long mesaId, Long itemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ComandaDTO fecharComanda(Long comandaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirMesa(Long mesaId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionarItensNaComanda(Long mesaId, List<Long> itemDTOIds) {
		// TODO Auto-generated method stub
		
	}
	
}
	
	