package com.devPontes.oMordomo.security.dto;

import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

public class AccountCredentials extends RepresentationModel<AccountCredentials> {

	private String username;
	private String password;
	
	public AccountCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public AccountCredentials() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(username);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountCredentials other = (AccountCredentials) obj;
		return Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "AccountCredentials [username=" + username + ", password=" + password + "]";
	}
	
	
	
}
