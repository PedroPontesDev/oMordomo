package com.devPontes.oMordomo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devPontes.oMordomo.model.dtos.UsuarioDTO;
import com.devPontes.oMordomo.services.impl.UsuarioServicesImpl;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UsuarioController {

	@Autowired
	private UsuarioServicesImpl userServices;
	
	public UsuarioDTO registrarNovoUsuario(@RequestBody UsuarioDTO novo) throws Exception {
		return userServices.registrarNovoUsuario(novo);
	}
	
}
