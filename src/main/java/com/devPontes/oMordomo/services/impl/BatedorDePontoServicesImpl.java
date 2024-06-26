package com.devPontes.oMordomo.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.model.dtos.BatedorDePontoDTO;
import com.devPontes.oMordomo.model.dtos.PontoDTO;
import com.devPontes.oMordomo.model.entities.BatedorDePonto;
import com.devPontes.oMordomo.model.mapper.MyMapper;
import com.devPontes.oMordomo.repositories.BatedorPontoRepository;
import com.devPontes.oMordomo.repositories.GarcomRepository;
import com.devPontes.oMordomo.repositories.PontoRepository;
import com.devPontes.oMordomo.services.BatedorDePontoServices;

import jakarta.transaction.Transactional;

@Service
public class BatedorDePontoServicesImpl implements BatedorDePontoServices {
	
	@Autowired
	GarcomRepository garcomRepository;
	
	@Autowired
	PontoRepository pontoRepository;
	
	@Autowired
	BatedorPontoRepository batedorRepository;

	@Override
	public List<BatedorDePontoDTO> exibirBatedorDePonto() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BatedorDePontoDTO criarNovoBatedorPonto(BatedorDePontoDTO novoBatedor) throws Exception {
		if(novoBatedor == null) throw new Exception("Os dados estão inconsistentes, tente novamente!");
		BatedorDePonto newBatedor = MyMapper.parseObject(novoBatedor, BatedorDePonto.class);
		if(newBatedor == null)throw new Exception("Os dados estão inconsistentes, tente novamente!");
		batedorRepository.save(newBatedor);
		var dto = MyMapper.parseObject(newBatedor, BatedorDePontoDTO.class);
		return dto;
	}

	@Override
	public BatedorDePontoDTO exibirBatedorPorId(Long batedorId) throws Exception {
		var entidade = batedorRepository.findById(batedorId);
		if(entidade.isPresent()) {
			var dto = MyMapper.parseObject(entidade.get(), BatedorDePontoDTO.class); 
			return dto;
		} throw new Exception("O batedor de ponto não existe!");
	}

	@Override
	public BatedorDePontoDTO registrarPontoFuncionario(PontoDTO ponto, Long funcionarioId, Long batedorId)
			throws Exception {
			return null;
	}

	@Override
	public BatedorDePontoDTO atualizarPontoFuncionario(Long pontoId, Long funcionarioId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BatedorDePontoDTO registrarFaltaFuncionario(LocalDate diaDaFalta, Long funcionarioId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long calcularHorasFuncionarioMes(Long funcionarioId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calcularBonusSalario(Long funcionarioId, Double reajuste) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PontoDTO exibirPontoFuncionario(Long funcionarioId) {
		// TODO Auto-generated method stub
		return null;
	}

}
	