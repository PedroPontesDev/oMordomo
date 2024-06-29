package com.devPontes.oMordomo.services.impl;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.model.dtos.ComandaDTO;
import com.devPontes.oMordomo.model.dtos.GarcomDTO;
import com.devPontes.oMordomo.model.entities.Comanda;
import com.devPontes.oMordomo.model.entities.Garcom;
import com.devPontes.oMordomo.model.entities.Ponto;
import com.devPontes.oMordomo.model.mapper.MyMapper;
import com.devPontes.oMordomo.repositories.GarcomRepository;
import com.devPontes.oMordomo.repositories.PontoRepository;
import com.devPontes.oMordomo.services.GarcomServices;

import jakarta.transaction.Transactional;

@Service
public class GarcomServicesImpl implements GarcomServices {
	
	@Autowired
	GarcomRepository garcomRepository;
	
	@Autowired
	PontoRepository pontoRepository;
	
	//A implementar o repositorio de Comandas

	@Override
	public List<GarcomDTO> listarTodos() throws AccountNotFoundException  {
		var todosGarcom = garcomRepository.findAll();
		if(!todosGarcom.isEmpty() && todosGarcom != null) {
			var dto = MyMapper.parseListObjects(todosGarcom, GarcomDTO.class);
			return dto;
		} throw new AccountNotFoundException("Nenhum garçom registrado ainda!");
	}

	@Override
	public GarcomDTO procurarPorId(Long id) throws Exception {
		var entidade = garcomRepository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
		if(entidade == null) throw new Exception("Garcom não pôde ser encontrado, tente novamente!");
		var dto = MyMapper.parseObject(entidade, GarcomDTO.class);
		return dto;
	}

	@Override
	public GarcomDTO procurarPorCpf(Long cpf) throws Exception {
		Optional<Garcom> entidade = garcomRepository.procurarPorCpf(cpf);
		if(entidade.isPresent()) {
			GarcomDTO dto = MyMapper.parseObject(entidade.get(), GarcomDTO.class);
			return dto;
		} throw new Exception("");
	}

	@Transactional
	@Override
	public GarcomDTO registrarNovoGarcom(GarcomDTO novoGarcom) throws Exception {
	    // Mapeando o DTO para a entidade Garcom
	    Garcom entidade = MyMapper.parseObject(novoGarcom, Garcom.class);
	    if (entidade == null) throw new Exception("Garcom não pôde ser registrado, tente novamente!");

	    // Criando e salvando a entidade Ponto antes de associá-la ao Garcom
	    Ponto ponto = new Ponto();
	    ponto = pontoRepository.save(ponto);  // Supondo que você tem um pontoRepository para salvar a entidade Ponto

	    // Associando o Ponto salvo ao Garcom
	    entidade.setPontoGarcom(ponto);
	    
	    // Setando os outros atributos
	    entidade.setFullName(novoGarcom.getFullName());
	    entidade.setUsername(novoGarcom.getUsername());
	    entidade.setPassword(novoGarcom.getPassword());
	    entidade.setCpf(novoGarcom.getCpf());
	    entidade.setEmail(novoGarcom.getEmail());
	    entidade.setHorasTrabalhadasMes(novoGarcom.getHorasTrabalhadasMes());
	    entidade.setTeveFalta(novoGarcom.getTeveFalta());
	    
	    // Salvando a entidade Garcom
	    entidade = garcomRepository.save(entidade);

	    // Mapeando a entidade salva para DTO
	    var dto = MyMapper.parseObject(entidade, GarcomDTO.class);
	    return dto;
	}


	@Transactional
	@Override
	public GarcomDTO atualizarGarcomExistente(Long garcomId, GarcomDTO update) throws Exception {
		Optional<Garcom> entidadeExistente = garcomRepository.findById(garcomId);
		if(entidadeExistente.isPresent()) {
			Garcom entity = entidadeExistente.get();
			entity.setCpf(update.getCpf());
			entity.setEmail(update.getEmail());
			entity.setFullName(update.getFullName());
			entity.setHorasTrabalhadasMes(update.getHorasTrabalhadasMes());
			entity.setSalario(update.getSalario());
			entity.setPassword(update.getPassword());
			entity.setUsername(update.getUsername());
			entity = garcomRepository.save(entity);
			var dto = MyMapper.parseObject(entity, GarcomDTO.class);
			return dto;
		} else {
			throw new Exception("Não foi possivel atualizar os dados do garçom, verifique a existencia do usuário!");
		}
	}

	@Transactional
	@Override
	public GarcomDTO alterarSalarioGarcom(Long garcomId, Double novoSalario) throws Exception {
		var garcom = garcomRepository.findById(garcomId);
		if(garcom.isPresent()) {
			var entity = garcom.get();
			entity.setSalario(novoSalario);
			garcomRepository.setReajusteSalario(novoSalario);
			var dto = MyMapper.parseObject(entity, GarcomDTO.class);
			
			return dto;
		} throw new Exception("Usuário não encontrado");
	}

	@Override
	public ComandaDTO abrirNovaComanda(ComandaDTO abrirComanda, Long garcomId) throws Exception {
		Comanda novaComanda = MyMapper.parseObject(abrirComanda, Comanda.class);
		return abrirComanda;
		
	}

	@Override
	public void fecharComanda(Long comandaId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarGarcomExistente(Long garcomId) throws Exception {
		var entity = garcomRepository.findById(garcomId);
		if(entity.isPresent()) {
			garcomRepository.delete(entity.get());
		} throw new Exception("Não foi possivel loclaizar o usuário");
		
	}

	

}
	