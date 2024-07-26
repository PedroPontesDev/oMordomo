package com.devPontes.oMordomo.services.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) 
public class SumHoursWorkingException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

}
