package com.devPontes.oMordomo.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.model.dtos.BatedorDePontoDTO;
import com.devPontes.oMordomo.model.dtos.PontoDTO;
import com.devPontes.oMordomo.model.entities.BatedorDePonto;
import com.devPontes.oMordomo.model.entities.Garcom;
import com.devPontes.oMordomo.model.entities.Ponto;
import com.devPontes.oMordomo.model.mapper.MyMapper;
import com.devPontes.oMordomo.repositories.BatedorPontoRepository;
import com.devPontes.oMordomo.repositories.GarcomRepository;
import com.devPontes.oMordomo.repositories.PontoRepository;
import com.devPontes.oMordomo.repositories.UsuarioRepository;
import com.devPontes.oMordomo.services.BatedorDePontoServices;
import com.devPontes.oMordomo.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BatedorDePontoServicesImpl implements BatedorDePontoServices {

	@Autowired
	GarcomRepository garcomRepository;

	@Autowired
	PontoRepository pontoRepository;

	@Autowired
	BatedorPontoRepository batedorRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<BatedorDePontoDTO> exibirBatedorDePonto() throws Exception {
		var todosBatedor = batedorRepository.findAll();
		return MyMapper.parseListObjects(todosBatedor, BatedorDePontoDTO.class);
	}

	@Override
	public BatedorDePontoDTO criarNovoBatedorPonto(BatedorDePontoDTO novoBatedor) throws Exception {
        if (novoBatedor == null) {
            throw new Exception("Os dados estão inconsistentes, tente novamente!");
        }

        BatedorDePonto newBatedor = MyMapper.parseObject(novoBatedor, BatedorDePonto.class);
        if (newBatedor == null) {
            throw new Exception("Os dados estão inconsistentes, tente novamente!");
        }

        batedorRepository.save(newBatedor);
        return MyMapper.parseObject(newBatedor, BatedorDePontoDTO.class);
	}

	@Override
	public BatedorDePontoDTO exibirBatedorPorId(Long batedorId) throws Exception {
		var entidade = batedorRepository.findById(batedorId);
		if (entidade.isPresent()) {
			var dto = MyMapper.parseObject(entidade.get(), BatedorDePontoDTO.class);
			return dto;
		}
		throw new Exception("O batedor de ponto não existe!");
	}

	@Override
	public BatedorDePontoDTO registrarPontoFuncionario(PontoDTO ponto, Long funcionarioId, Long batedorId)
			throws Exception {
		Ponto pontoNovo = MyMapper.parseObject(ponto, Ponto.class);
		var funcionario = garcomRepository.findById(funcionarioId);
		var batedor = batedorRepository.findById(batedorId);
		if (batedor.isPresent() && funcionario.isPresent()) {
			pontoNovo.setGarcom(funcionario.get());

			LocalDate dataMesFalta = batedor.get().getDataDoMes();
			BatedorDePonto registro = batedor.get();
			
			registro.getPontos().add(pontoNovo);
			registro.setHouveFalta(null);
			registro.setDataDoMes(dataMesFalta);
			registro.setPontos(new ArrayList<>());
			pontoRepository.save(pontoNovo);
			batedorRepository.save(registro);
			funcionario.get().setPontoGarcom(pontoNovo);
			garcomRepository.save(funcionario.get());
			var dto = MyMapper.parseObject(registro, BatedorDePontoDTO.class);
			return dto;
		}
		throw new Exception("Não foi possivel registrar do funcionario!");

	}

	@Override
	public BatedorDePontoDTO atualizarPontoFuncionario(PontoDTO ponto, Long funcionarioId, Long batedorId) throws Exception {
		var funcionarioData = usuarioRepository.findById(funcionarioId);
		var batedorPonto = batedorRepository.findById(batedorId);
		Ponto pontoGarcom = null;
		if(ponto != null && funcionarioData.isPresent() && batedorPonto.isPresent()) {
			Garcom garcom = MyMapper.parseObject(funcionarioData, Garcom.class);
			pontoGarcom = MyMapper.parseObject(ponto, Ponto.class);
			garcom.setPontoGarcom(pontoGarcom);
			garcomRepository.save(garcom);
			pontoGarcom.setGarcom(garcom);
			pontoRepository.save(pontoGarcom);
			BatedorDePonto batedor = batedorPonto.get();
			var associarPonto = batedor.getPontos().add(pontoGarcom);
			batedorRepository.save(batedor);
			var dto = MyMapper.parseObject(batedor, BatedorDePontoDTO.class);
			return dto;
		} throw new  ResourceNotFoundException(pontoGarcom.getId());
	}

	@Override
	public BatedorDePontoDTO registrarFaltaFuncionario(LocalDate diaDaFalta, Long funcionarioId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer calcularHorasFuncionarioMes(Long funcionarioId) throws Exception {
		Long totalHoras = 0L;
		var entidade = usuarioRepository.findById(funcionarioId);
		if(entidade.isPresent()) {
			Garcom garcom = MyMapper.parseObject(entidade, Garcom.class);
			var horas =  garcom.getPontoGarcom().getHorarioEntrada().getHour();
			var mes = garcom.getPontoGarcom().getHorarioEntrada().getMonthValue();
			Integer soma = (horas / mes) * mes;
			garcom.setHorasTrabalhadasMes(totalHoras);
			garcomRepository.save(garcom);
			return soma;
		} throw new Exception("Não é possivel calcular total de horas, verifique os dados e tente novamente!");
	}

	@Override
	public Double calcularBonusSalario(Long funcionarioId, Double reajuste) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PontoDTO exibirPontoFuncionario(Long funcionarioId) throws Exception {
		var entidade = usuarioRepository.findById(funcionarioId);
		if(entidade != null) {
			Garcom funcionario = MyMapper.parseObject(entidade, Garcom.class);
			Ponto ponto = funcionario.getPontoGarcom();
			PontoDTO dtoPonto = MyMapper.parseObject(ponto, PontoDTO.class);
			return dtoPonto;
		} throw new Exception("");
		
	}

}
