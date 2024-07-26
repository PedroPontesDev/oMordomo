package com.devPontes.oMordomo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devPontes.oMordomo.model.dtos.BatedorDePontoDTO;
import com.devPontes.oMordomo.model.dtos.PontoDTO;
import com.devPontes.oMordomo.services.impl.BatedorDePontoServicesImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/v1/controle-ponto")
@Tag(name = "BatedorPonto")
public class BatedorPontoController {
	
	@Autowired
	private BatedorDePontoServicesImpl batedorService;
	
	@Operation(description = "", tags = "BatedorPonto")
	@GetMapping(path = "/exibir-ponto-funcionario/{funcionarioId}")
	public ResponseEntity<PontoDTO> exibirPontoFuncionario(@PathVariable Long funcionarioId) throws Exception {
		var ponto = batedorService.exibirPontoFuncionario(funcionarioId);
		return null;
		
	}
	
	@GetMapping(path = "/exibir-todos")
	public ResponseEntity<List<BatedorDePontoDTO>> listarTodosBatedoresDePonto() throws Exception {
		List<BatedorDePontoDTO> list = batedorService.exibirTodosBatedorDePonto();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
	}
	
	@GetMapping(path = "/exibir-id/{id}")
	public ResponseEntity<BatedorDePontoDTO> exibirBatedorPorId(@PathVariable Long id) throws Exception {
		BatedorDePontoDTO batedorPonto = batedorService.exibirBatedorPorId(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(batedorPonto);
	}
	
	@PostMapping(path = "/criar-batedor")
	public ResponseEntity<BatedorDePontoDTO> criarBatedorPonto(@RequestBody BatedorDePontoDTO novoBatedor) throws Exception {
		BatedorDePontoDTO setService = batedorService.criarNovoBatedorPonto(novoBatedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(setService);
		
	}
	
	@PostMapping(path = "/registrar-ponto/{funcionarioId}/{batedorId}")
	public ResponseEntity<BatedorDePontoDTO> registrarPontoFuncionario(@RequestBody PontoDTO ponto,
			@PathVariable Long funcionarioId, @PathVariable Long batedorId) throws Exception {
		BatedorDePontoDTO baterPonto = batedorService.registrarPontoFuncionario(ponto, funcionarioId, batedorId);
		return ResponseEntity.status(HttpStatus.CREATED).body(baterPonto);
	}
	
	@PutMapping(path = "/atualizar-ponto/{funcionarioId}/{batedorId}")
	public ResponseEntity<BatedorDePontoDTO> atualizarPontoFuncionario(@RequestBody PontoDTO novoPonto, 
			@PathVariable Long funcionarioId, @PathVariable Long batedorId) throws Exception{
		var updatePonto = batedorService.atualizarPontoFuncionario(novoPonto, funcionarioId, batedorId);
		return ResponseEntity.ok(updatePonto);
		
	}
	
	
	@PostMapping(path = "/registrar-falta-funcionario/{funcionarioId}/{batedorId}")
	public ResponseEntity<String> registrarFaltaFuncionario(
			@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate diaDaFalta, 
			@PathVariable Long funcionarioId, @PathVariable Long batedorId) throws Exception {
		batedorService.registrarFaltaFuncionario(diaDaFalta, funcionarioId, batedorId);
		return ResponseEntity.ok("Falta registrada com sucesso!");
		
	}
	
	@PostMapping(path = "/calcular-horas-funcionario/{funcionarioId}")
	public ResponseEntity<Long> calcularHorasFuncionarMes(@PathVariable Long funcionarioId) throws Exception {
		Long total = batedorService.calcularHorasFuncionarioMes(funcionarioId);
		return ResponseEntity.ok(total);
	}
	
	
}
