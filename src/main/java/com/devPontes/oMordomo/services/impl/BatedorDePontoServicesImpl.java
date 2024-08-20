package com.devPontes.oMordomo.services.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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
	public List<BatedorDePontoDTO> exibirTodosBatedorDePonto() throws ResourceNotFoundException {
		var todosBatedor = batedorRepository.findAll();
		return MyMapper.parseListObjects(todosBatedor, BatedorDePontoDTO.class);
	}

	@Override
	public BatedorDePontoDTO criarNovoBatedorPonto(BatedorDePontoDTO novoBatedor) {
		if (novoBatedor == null) {
			throw new ResourceNotFoundException(novoBatedor.getId());
		}
		BatedorDePonto newBatedor = MyMapper.parseObject(novoBatedor, BatedorDePonto.class);
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

	public BatedorDePontoDTO registrarPontoFuncionario(PontoDTO ponto, Long funcionarioId, Long batedorId) {
		Ponto pontoNovo = MyMapper.parseObject(ponto, Ponto.class);
		var funcionario = garcomRepository.findById(funcionarioId);
		var batedor = batedorRepository.findById(batedorId);

		if (batedor.isPresent() && funcionario.isPresent()) {
			Garcom garcom = funcionario.get();
			BatedorDePonto batedorDePonto = batedor.get();

			// Configurar as relações
			pontoNovo.setGarcom(garcom);
			pontoNovo.setBatedorDePonto(batedorDePonto);
			pontoNovo.setHorarioEntrada(ponto.getHorarioEntrada());
			pontoNovo.setHorarioSaida(ponto.getHorarioSaida());
			// Salvar o ponto primeiro para garantir que ele tenha um ID
			pontoNovo = pontoRepository.save(pontoNovo);

			// Atualizar as coleções em Garcom e BatedorDePonto
			garcom.getPontos().add(pontoNovo);
			batedorDePonto.getPontos().add(pontoNovo);

			// Salvar as entidades relacionadas
			garcomRepository.save(garcom);
			batedorRepository.save(batedorDePonto);

			// Converter o resultado em DTO
			var dto = MyMapper.parseObject(batedorDePonto, BatedorDePontoDTO.class);
			return dto;
		}
		throw new ResourceNotFoundException("Batedor de Ponto com ID " + batedorId + " não encontrado");
	}

	@Override
	public BatedorDePontoDTO atualizarPontoFuncionario(PontoDTO ponto, Long funcionarioId, Long batedorId)
			throws Exception {
		var funcionarioData = usuarioRepository.findById(funcionarioId);
		var batedorPonto = batedorRepository.findById(batedorId);
		Ponto pontoGarcom = null;
		if (ponto != null && funcionarioData.isPresent() && batedorPonto.isPresent()) {
			Garcom garcom = MyMapper.parseObject(funcionarioData, Garcom.class);
			pontoGarcom = MyMapper.parseObject(ponto, Ponto.class);
			garcom.getPontos().add(pontoGarcom);
			garcomRepository.save(garcom);

			pontoGarcom.setGarcom(garcom);
			pontoRepository.save(pontoGarcom);
			BatedorDePonto batedor = batedorPonto.get();
			var associarPonto = batedor.getPontos().add(pontoGarcom);
			batedorRepository.save(batedor);

			var dto = MyMapper.parseObject(batedor, BatedorDePontoDTO.class);
			return dto;
		}
		throw new ResourceNotFoundException(pontoGarcom.getId());
	}

	@Override
	public Long calcularHorasFuncionarioMes(Long funcionarioId, int mesDesejado) throws Exception {
		Long totalHoras = 0L;
		Integer mesQuery = mesDesejado;
		var entidadeFuncionario = garcomRepository.findById(funcionarioId); // O(1)
		if (entidadeFuncionario.isPresent()) {
			Garcom garcom = entidadeFuncionario.get();
			Long totalHorasPorMes = 0l;
			for (Ponto ponto : garcom.getPontos()) {
				if(mesQuery == ponto.getHorarioEntrada().getMonthValue()) {
					if (ponto.getHorarioEntrada() != null && ponto.getHorarioSaida() != null) {
						Long total = Duration.between(ponto.getHorarioEntrada(), ponto.getHorarioSaida()).toHours();
						totalHoras = total;
					} else {
						throw new Exception("Mês desejado o usuario provalvemente teve falta!");
					}
				}
			}
			garcom.setHorasTrabalhadasMes(totalHoras);
			garcomRepository.save(garcom);
			return totalHoras;
		} else {
			throw new Exception("Não é possível calcular total de horas, verifique os dados e tente novamente!");
		}
	}

	@Override
	public Double calcularBonusSalario(Long funcionarioId, Double reajuste) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PontoDTO exibirPontoFuncionario(Long funcionarioId) throws Exception {
		var entidade = usuarioRepository.findById(funcionarioId);
		if (entidade != null) {
			Garcom funcionario = MyMapper.parseObject(entidade, Garcom.class);
			for (Ponto ponto : funcionario.getPontos()) {
				return MyMapper.parseObject(ponto, PontoDTO.class);
			}
		}
		throw new Exception("Não é possivel exibir pontos do funcionario!");

	}

	@Override
	@Transactional
	public void registrarFaltaFuncionario(LocalDate diaDaFalta, Long funcionarioId, Long batedorId) throws Exception {
		Optional<BatedorDePonto> batedorOptional = batedorRepository.findById(batedorId);
		if (batedorOptional.isPresent()) {
			BatedorDePonto batedor = batedorOptional.get();
			Garcom garcom = garcomRepository.findById(funcionarioId)
					.orElseThrow(() -> new Exception("Garcom não encontrado com ID: " + funcionarioId));

			Ponto novoPonto = new Ponto();
			novoPonto.setGarcom(garcom);
			novoPonto.setDataDoMes(diaDaFalta);
			novoPonto.setBatedorDePonto(batedor);

			batedor.getPontos().add(novoPonto);
			batedor.setHouveFalta(true);
			garcom.setTeveFalta(true);
			garcomRepository.save(garcom);
			pontoRepository.save(novoPonto);
			batedorRepository.save(batedor);
		} else {
			throw new Exception("Batedor de Ponto não encontrado com ID: " + batedorId);
		}
	}

}
