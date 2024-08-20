package com.devPontes.oMordomo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devPontes.oMordomo.model.dtos.UsuarioDTO;
import com.devPontes.oMordomo.security.services.jwt.TokenServices;
import com.devPontes.oMordomo.services.impl.UsuarioServicesImpl;

@RestController
@RequestMapping("/api/v1/login")
public class AuthController {
	

	@Autowired
	private UsuarioServicesImpl userServices;
	
	@PostMapping(path = "/register-user")
	public UsuarioDTO registrarNovoUsuario(@RequestBody UsuarioDTO novo) throws Exception {
		return userServices.registrarNovoUsuario(novo);
	}
	
}