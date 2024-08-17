package com.devPontes.oMordomo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.devPontes.oMordomo.model.dtos.ComandaDTO;
import com.devPontes.oMordomo.services.impl.ComandaServicesImpl;
import com.devPontes.oMordomo.services.impl.MesaServicesImpl;

@RestController
@RequestMapping(path = "/api/v1/comanda")
public class ComandaController {
	
	@Autowired
	private ComandaServicesImpl comandaServices;
	
	@Autowired
	private MesaServicesImpl mesaServices;

	//A implementar

	
}
