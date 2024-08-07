package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Permissão implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;
	
	private String descrição;
	

}
