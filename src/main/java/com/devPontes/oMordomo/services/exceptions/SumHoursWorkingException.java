package com.devPontes.oMordomo.services.exceptions;

import java.io.Serializable;

public class SumHoursWorkingException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	
	public String getMessage(String message) {
		return message;
	}
	
	

}
