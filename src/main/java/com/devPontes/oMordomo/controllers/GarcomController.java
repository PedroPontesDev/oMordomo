package com.devPontes.oMordomo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devPontes.oMordomo.model.dtos.GarcomDTO;
import com.devPontes.oMordomo.services.impl.GarcomServicesImpl;

@RestController
@RequestMapping(path = "/api/v1/garcom")
public class GarcomController {
	
	@Autowired
	private GarcomServicesImpl garcomServices;
	
	
	@GetMapping(path = "/listar-todos")
	public ResponseEntity<List<GarcomDTO>> listarTodosGarcoms() throws Exception {
		var todosGarcom =  garcomServices.listarTodos();
		return new ResponseEntity<>(todosGarcom, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/search/buscar-id/{id}")
	public ResponseEntity<GarcomDTO> buscarPorId(@PathVariable Long id) throws Exception {
		var garcom = garcomServices.procurarPorId(id);
		return new ResponseEntity<>(garcom, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/search/buscar-cpf")
	public ResponseEntity<GarcomDTO> buscarPorCpf(@RequestParam Long cpf) throws Exception{
		var garcom = garcomServices.procurarPorCpf(cpf);
		return new ResponseEntity<>(garcom, HttpStatus.FOUND);
	}
	
	@PostMapping(path = "/registrar-garcom")
	public ResponseEntity<GarcomDTO> registrarGarcom(@RequestBody GarcomDTO novoGarcom) throws Exception {
		GarcomDTO novaEntidade = garcomServices.registrarNovoGarcom(novoGarcom);
		return new ResponseEntity<>(novaEntidade, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/atualizar-garcom/{id}")
	public ResponseEntity<GarcomDTO> atualizarGarcomExistente(@PathVariable Long id, @RequestBody GarcomDTO updateGarcom) throws Exception {
		var garcomUpdated = garcomServices.atualizarGarcomExistente(id, updateGarcom);
		return ResponseEntity.status(HttpStatus.OK).body(garcomUpdated);
	}
	
	@PatchMapping(path = "/atualizar-cpf/{id}/{novoCpf}")
	public ResponseEntity<GarcomDTO> atualizarCpfGarcom(@PathVariable Long id, @PathVariable Long novoCpf) throws Exception {
		var garcomUpdated = garcomServices.alterarCpfGarcom(id, novoCpf);
		return ResponseEntity.status(HttpStatus.OK).body(garcomUpdated);
	}
	
	@PatchMapping(path = "/atualizar-salario/{garcomId}")
	public ResponseEntity<String> alterSalarioGarcom(@PathVariable Long garcomId, @RequestParam Double novoSalario) throws Exception {
		garcomServices.alterarSalarioGarcom(garcomId, novoSalario);
		return ResponseEntity.status(HttpStatus.OK).body("Salário atualizado com sucesso!");
	}
	

	
}
