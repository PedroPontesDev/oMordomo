package com.devPontes.oMordomo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devPontes.oMordomo.model.dtos.BatedorDePontoDTO;
import com.devPontes.oMordomo.services.impl.BatedorDePontoServicesImpl;

@RestController
@RequestMapping(path = "/api/v1/controle-ponto")
public class BatedorPontoController {
	
	@Autowired
	private BatedorDePontoServicesImpl batedorService;
	
	@GetMapping(path = "/exibir-todos")
	public ResponseEntity<List<BatedorDePontoDTO>> listarTodosBatedoresDePonto() throws Exception {
		List<BatedorDePontoDTO> list = batedorService.exibirBatedorDePonto();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
	}
	
	@PostMapping(path = "/criar-batedor")
	public ResponseEntity<BatedorDePontoDTO> criarBatedorPonto(@RequestBody BatedorDePontoDTO novoBatedor) throws Exception {
		BatedorDePontoDTO setService = batedorService.criarNovoBatedorPonto(novoBatedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(setService);
		
	}
	
	
	
}
