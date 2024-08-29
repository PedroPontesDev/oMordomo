package com.devPontes.oMordomo.security.dto;

import java.io.Serializable;
import java.util.Objects;

public class LoginRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
    private String password;
    
	public LoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}
    
	public LoginRequest() {
		
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
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginRequest other = (LoginRequest) obj;
		return Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + password + "]";
	}
    
	
	
	
}
