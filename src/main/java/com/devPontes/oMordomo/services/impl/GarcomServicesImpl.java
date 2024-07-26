package com.devPontes.oMordomo.services.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.controllers.GarcomController;
import com.devPontes.oMordomo.model.dtos.ComandaDTO;
import com.devPontes.oMordomo.model.dtos.GarcomDTO;
import com.devPontes.oMordomo.model.dtos.ItemDTO;
import com.devPontes.oMordomo.model.entities.Comanda;
import com.devPontes.oMordomo.model.entities.Garcom;
import com.devPontes.oMordomo.model.entities.Item;
import com.devPontes.oMordomo.model.entities.Ponto;
import com.devPontes.oMordomo.model.enums.StatusMesa;
import com.devPontes.oMordomo.model.mapper.MyMapper;
import com.devPontes.oMordomo.repositories.GarcomRepository;
import com.devPontes.oMordomo.repositories.MesaRepository;
import com.devPontes.oMordomo.repositories.PontoRepository;
import com.devPontes.oMordomo.services.GarcomServices;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn; //Adicionei os Imports Estaticos Para HATEOAS


import jakarta.transaction.Transactional;

@Service
public class GarcomServicesImpl implements GarcomServices {
	
	@Autowired
	GarcomRepository garcomRepository;
	
	@Autowired
	PontoRepository pontoRepository;
	
	@Autowired
	MesaRepository mesaRepository;

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
		dto.add(linkTo(methodOn(GarcomController.class).buscarPorId(id)).withSelfRel());
		return dto;
	}

	@Override
	public GarcomDTO procurarPorCpf(Long cpf) throws Exception {
			return buscarBinariaCpf(cpf);
	}
		

	@Transactional
	@Override
	public GarcomDTO registrarNovoGarcom(GarcomDTO novoGarcom) throws Exception {
	    // Mapeando o DTO para a entidade Garcom
	    Garcom entidade = MyMapper.parseObject(novoGarcom, Garcom.class);
	    if (entidade == null) throw new Exception("Garcom não pôde ser registrado, tente novamente!");
	 
	    // Criando e salvando a entidade Ponto antes de associá-la ao Garcom
	    List<Ponto> pontos = new ArrayList<>();
	    for(Ponto ponto : pontos) {
	    	  ponto.setBatedorDePonto(null);
	    	  ponto.setGarcom(entidade);
	    	  ponto.setHorarioEntrada(null);
	    	  ponto.setHorarioSaida(null);
	    	  pontoRepository.save(ponto); 
	    	  entidade.getPontos().add(ponto);
	    }
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
	    var garcomOptional = garcomRepository.findById(garcomId);
	    if (garcomOptional.isPresent()) {
	        garcomRepository.setReajusteSalario(novoSalario, garcomId);
	        Garcom garcom = garcomOptional.get();
	        garcom.setSalario(novoSalario); // Atualiza o objeto na memória
	        return MyMapper.parseObject(garcom, GarcomDTO.class);
	    } else {
	        throw new Exception("Usuário não encontrado");
	    }
	}
	
	@Transactional
	public GarcomDTO alterarCpfGarcom(Long garcomId, Long novoCpf) throws Exception {
	    var garcom = garcomRepository.findById(garcomId);
	    if(garcom.isPresent()) {
	        var entity = garcom.get();
	        entity.setCpf(novoCpf);
	        garcomRepository.save(entity);
	        var dto = MyMapper.parseObject(entity, GarcomDTO.class);
	        return dto;
	    } else {
	        throw new Exception("Usuário não encontrado");
	    }
	}

	@Override
	public ComandaDTO abrirNovaComanda(ComandaDTO abrirComanda, List<ItemDTO> items, Long garcomId, Long mesaId, Long clientId) throws Exception {
		Comanda novaComanda = MyMapper.parseObject(abrirComanda, Comanda.class);
		var itemsEntity = MyMapper.parseListObjects(items, Item.class);
		var garcom = garcomRepository.findById(garcomId);
		var mesa = mesaRepository.findById(mesaId);
		if(garcom.isPresent() && mesa.isPresent() && !itemsEntity.isEmpty()) {
			novaComanda.getItems().addAll(itemsEntity);
			novaComanda.setGarcomComanda(garcom.get());
			novaComanda.setMesa(mesa.get());
			mesa.get().setStatusMesa(StatusMesa.OCUPADA);
			
		}
		return abrirComanda;	//A TERMINAR IMPLEMENTAÇÃO! 
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
	
	public GarcomDTO buscarBinariaCpf(Long cpf) throws Exception {
		var listaGarcoms = garcomRepository.findAll().stream()
				.sorted(Comparator.comparing(Garcom::getCpf))
				.collect(Collectors.toList());
		
		Integer alto = 0;
		Integer baixo = listaGarcoms.size() - 1;
		
		while(alto <= baixo) {
			var meio = alto + (baixo - alto) / 2;
			Garcom garcomMeio = listaGarcoms.get(meio);
			if(garcomMeio.getCpf().equals(cpf)) { 
				return MyMapper.parseObject(garcomMeio, GarcomDTO.class);
			} else if(garcomMeio.getCpf() < cpf) {
				alto = meio + 1; 
			} else {
				baixo = meio - 1;
			}
		}   throw new Exception("Garcom não encontrado pelo CPF informado!");
	}
}
	
	