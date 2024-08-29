package com.devPontes.oMordomo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devPontes.oMordomo.model.dtos.UsuarioDTO;
import com.devPontes.oMordomo.security.dto.LoginRequest;
import com.devPontes.oMordomo.services.impl.AuthService;
import com.devPontes.oMordomo.services.impl.UsuarioServicesImpl;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
	private UsuarioServicesImpl userServices;
	
	@Autowired
	private AuthService authServices;

	@PostMapping(path = "/register-admin")
	public UsuarioDTO registrarNovoUsuario(@RequestBody UsuarioDTO novo) throws Exception {
		return userServices.registrarNovoUsuario(novo);
	}

	@PostMapping(path = "/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) throws Exception {
		String token = authServices.authenticateAndGetToken(loginRequest);
    
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token);

		return ResponseEntity.ok().headers(headers).body("Login successful");                     
	}
}
