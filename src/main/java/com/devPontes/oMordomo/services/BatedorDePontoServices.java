package com.devPontes.oMordomo.services;

import java.time.LocalDate;

import com.devPontes.oMordomo.model.dtos.BatedorDePontoDTO;
import com.devPontes.oMordomo.model.dtos.PontoDTO;

public interface BatedorDePontoServices {
	
	BatedorDePontoDTO registrarPontoFuncionario(PontoDTO ponto, Long usuarioId, Long batedorId) throws Exception;
	BatedorDePontoDTO registrarFaltaFuncionario(LocalDate diaDaFalta, Long usuarioId) throws Exception;
	BatedorDePontoDTO calcularHorasFuncionarioMes(Long funcionarioId) throws Exception;
	
	
}
