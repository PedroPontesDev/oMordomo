package com.devPontes.oMordomo.model.entities;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.activation.DataSource;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;

@Entity
@MappedSuperclass
public abstract class Relatorio {
	
	@Autowired
	private static final Object jasperReport = null;
	
	@Autowired
	private static final String pathJrxml = null;
	
	@Autowired
	private static final DataSource dbConection = null;
	
	//A implementar relatorios com JasperReports
	
	
}
