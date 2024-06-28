package com.devPontes.oMordomo.exceptions;

import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	
	public String getMessage(String message) {
		return message;
	}
	
	

}
