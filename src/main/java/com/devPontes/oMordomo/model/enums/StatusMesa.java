package com.devPontes.oMordomo.model.enums;

public enum StatusMesa {
	
	LIVRE, OCUPADA, RESERVADA;
	
	public static StatusMesa parseValue(String status) {
		if(status == null) {
			throw new IllegalArgumentException("O status que você está passando está nulo");
		}
		switch(status.toLowerCase()) {
			case "livre":
				return LIVRE;
			case "ocupada":
				return OCUPADA;
			case "reservada":
				return RESERVADA;
			 default:
	                throw new IllegalArgumentException("Unknown status: " + status);
		}
	}

}
