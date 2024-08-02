package com.devPontes.oMordomo.services;

import java.time.LocalDate;
import java.util.List;

import com.devPontes.oMordomo.model.dtos.BatedorDePontoDTO;
import com.devPontes.oMordomo.model.dtos.PontoDTO;

public interface BatedorDePontoServices {
    List<BatedorDePontoDTO> exibirTodosBatedorDePonto() throws Exception;
    BatedorDePontoDTO criarNovoBatedorPonto(BatedorDePontoDTO novoBatedor) throws Exception;
    BatedorDePontoDTO exibirBatedorPorId(Long batedorId) throws Exception;
    BatedorDePontoDTO registrarPontoFuncionario(PontoDTO ponto, Long funcionarioId, Long batedorId) throws Exception;
    BatedorDePontoDTO atualizarPontoFuncionario(PontoDTO ponto, Long funcionarioId, Long batedorId) throws Exception;
    void registrarFaltaFuncionario(LocalDate diaDaFalta, Long funcionarioId, Long batedorId) throws Exception;
    Long calcularHorasFuncionarioMes(Long funcionarioId, int mesDesejado) throws Exception;
    Double calcularBonusSalario(Long funcionarioId, Double reajuste) throws Exception;
    PontoDTO exibirPontoFuncionario(Long funcionarioId) throws Exception;

}
