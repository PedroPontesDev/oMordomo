package com.devPontes.oMordomo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devPontes.oMordomo.model.dtos.GarcomDTO;
import com.devPontes.oMordomo.services.impl.GarcomServicesImpl;

@RestController
@RequestMapping(path = "/garcoms")
public class GarcomController {
	
	@Autowired
	private GarcomServicesImpl garcomServices;
	
	
	@GetMapping(path = "/listar-todos")
	public ResponseEntity<List<GarcomDTO>> listarTodosGarcoms() throws Exception {
		var todosGarcom =  garcomServices.listarTodos();
		return new ResponseEntity<>(todosGarcom, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(path = "/registrar-garcom")
	public ResponseEntity<GarcomDTO> registrarGarcom(@RequestBody GarcomDTO novoGarcom) throws Exception {
		GarcomDTO novaEntidade = garcomServices.registrarNovoGarcom(novoGarcom);
		return new ResponseEntity<>(novaEntidade, HttpStatus.CREATED);
	}
	
	
	
}
