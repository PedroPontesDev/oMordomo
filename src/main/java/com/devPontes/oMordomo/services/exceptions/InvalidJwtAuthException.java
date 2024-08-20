package com.devPontes.oMordomo.services.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN) 
public class InvalidJwtAuthException extends AuthenticationException implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public InvalidJwtAuthException(String msg) {
		super(msg);
	}



}
