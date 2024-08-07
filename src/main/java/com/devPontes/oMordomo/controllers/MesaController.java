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

import com.devPontes.oMordomo.model.dtos.GarcomDTO;
import com.devPontes.oMordomo.services.impl.ComandaServicesImpl;
import com.devPontes.oMordomo.services.impl.GarcomServicesImpl;
import com.devPontes.oMordomo.services.impl.MesaServicesImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/v1/mesas")
@Tag(name = "Gerenciamento De Mesas")
public class MesaController {
	
	@Autowired
	MesaServicesImpl mesaServices;

	/*A IMPLEMENTAR METODOS/FUNÇÕES PARA RESERVAR MESA, ABRIR E FECHAR COMANDAS	*/
	
}
