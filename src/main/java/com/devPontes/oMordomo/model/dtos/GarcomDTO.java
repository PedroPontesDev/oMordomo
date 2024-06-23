package com.devPontes.oMordomo.model.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.hateoas.RepresentationModel;

import com.devPontes.oMordomo.model.entities.Gorjeta;


public class GarcomDTO extends RepresentationModel<GarcomDTO> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;  
	private String fullName;
	private String email;
	private String username;
	private String password;
	private Long cpf;

	private Double salario;

	private LocalDateTime horasTrabalhadasMes;

	private Boolean teveFalta;

	private Set<Gorjeta> gorjetas = new TreeSet<>();

	public GarcomDTO(Long id, String fullName, String email, String username, String password, Long cpf, Double salario,
			LocalDateTime horasTrabalhadasMes, Boolean teveFalta, Set<Gorjeta> gorjetas) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.cpf = cpf;
		this.salario = salario;
		this.horasTrabalhadasMes = horasTrabalhadasMes;
		this.teveFalta = teveFalta;
		this.gorjetas = gorjetas;
	}
	
	public GarcomDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public LocalDateTime getHorasTrabalhadasMes() {
		return horasTrabalhadasMes;
	}

	public void setHorasTrabalhadasMes(LocalDateTime horasTrabalhadasMes) {
		this.horasTrabalhadasMes = horasTrabalhadasMes;
	}

	public Boolean getTeveFalta() {
		return teveFalta;
	}

	public void setTeveFalta(Boolean teveFalta) {
		this.teveFalta = teveFalta;
	}

	public Set<Gorjeta> getGorjetas() {
		return gorjetas;
	}

	public void setGorjetas(Set<Gorjeta> gorjetas) {
		this.gorjetas = gorjetas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id);
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
		GarcomDTO other = (GarcomDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "GarcomDTO [id=" + id + ", fullName=" + fullName + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", cpf=" + cpf + ", salario=" + salario + ", horasTrabalhadasMes="
				+ horasTrabalhadasMes + ", teveFalta=" + teveFalta + ", gorjetas=" + gorjetas + "]";
	}
	
	
	
	

}
