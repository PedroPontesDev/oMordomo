package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "usuario_tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_completo")
	private String fullName;
	@Column
	private String email;

	@Column(name = "cpf", unique = true)
	private Long cpf;

	@Column(name = "account_non_expired")
	private Boolean accountNonExpired;

	@Column(name = "account_non_locked")
	private Boolean accountNonLocked;

	@Column(name = "credentials_non_expired")
	private Boolean credentialsNonExpired;

	@Column(name = "enabled")
	private Boolean enabled;
	
	private String username;
	
	private String password;


	public Usuario(Long id, String fullName, String email, String username, String password, Long cpf) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.cpf = cpf;
	}

	public Usuario() {

	}

	/*
	 * public List<String> getRoles() { List<String> roles = new ArrayList<>(); for
	 * (Permissão permission : permissions) {
	 * 
	 * } return roles; }
	 */

	public String getFullName() {
		return fullName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", fullName=" + fullName + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", cpf=" + cpf + "]";
	}

}
