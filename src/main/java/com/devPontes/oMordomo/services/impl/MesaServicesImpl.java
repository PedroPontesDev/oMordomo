package com.devPontes.oMordomo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.model.dtos.MesaDTO;
import com.devPontes.oMordomo.model.entities.Mesa;
import com.devPontes.oMordomo.model.enums.StatusMesa;
import com.devPontes.oMordomo.model.mapper.MyMapper;
import com.devPontes.oMordomo.repositories.MesaRepository;
import com.devPontes.oMordomo.services.MesaServices;

@Service
public class MesaServicesImpl implements MesaServices {

	@Autowired
	private MesaRepository mesaRepository;
	
	@Override
	public List<MesaDTO> exibirTodasMesas() throws Exception {
		List<Mesa> todasMesa = mesaRepository.findAll();
		if(!todasMesa.isEmpty()) {
			return MyMapper.parseListObjects(todasMesa, MesaDTO.class);
		} throw new Exception("");
	}

	@Override
	public MesaDTO exibirMesaPorIdentificador(Long mesaId) throws Exception {
		Mesa mesaEntidade = mesaRepository.findById(mesaId)
					.orElseThrow(() -> new Exception("Mesa não encontrada!"));
		if(mesaEntidade != null) {
			return MyMapper.parseObject(mesaEntidade, MesaDTO.class);
		} throw new Exception("Mesa não pôde ser encontrada por ID" + mesaId);
	}

	@Override
	public MesaDTO registrarNovaMesa(MesaDTO mesaDTO) throws Exception {
		Mesa mesaQuery = MyMapper.parseObject(mesaDTO, Mesa.class);
		var query = mesaRepository.findById(mesaDTO.getId());
		if(query.isPresent()) throw new Exception("Mesa já existe!");
		var dto = MyMapper.parseObject(mesaQuery, MesaDTO.class);
		mesaRepository.save(mesaQuery);
		return dto;
		
	}

	@Override
	public MesaDTO atualizarMesa(Long mesaExistenteId, MesaDTO update) throws Exception {
		Mesa updated = MyMapper.parseObject(update, Mesa.class);
		var existente = mesaRepository.findById(mesaExistenteId);
		if(existente.isPresent()) {
			Mesa mesaExistente = existente.get();
			mesaExistente.setComanda(updated.getComanda());
			mesaExistente.setDiaDaReserva(updated.getDiaDaReserva());
			mesaExistente.setEstaReservada(updated.getEstaReservada());
			mesaExistente.setStatusMesa(updated.getStatusMesa());
			var dto = MyMapper.parseObject(mesaExistente, MesaDTO.class);
			mesaRepository.save(mesaExistente);
			return dto;
		} throw new Exception("Não foi possivel atualizar mesa existente com o ID" + mesaExistenteId);
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
	public void excluirMesa(Long mesaId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionarItensNaComanda(Long mesaId, List<Long> itemDTOIds) {
		// TODO Auto-generated method stub
		
	}
	
}
	
	