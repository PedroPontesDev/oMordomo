package com.devPontes.oMordomo.services.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.model.dtos.BatedorDePontoDTO;
import com.devPontes.oMordomo.model.dtos.PontoDTO;
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

	@Transactional
	@Override
	public BatedorDePontoDTO registrarPontoFuncionario(PontoDTO ponto, Long usuarioId, Long batedorId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BatedorDePontoDTO registrarFaltaFuncionario(LocalDate diaDaFalta, Long usuarioId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BatedorDePontoDTO calcularHorasFuncionarioMes(Long funcionarioId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	


}
	