package com.devPontes.oMordomo.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_garcom")
@PrimaryKeyJoinColumn(name = "usuario.id")
@DiscriminatorValue("GARCOM")
public class Garcom extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(length = 90, nullable = false)
	private Double salario;

	@Column(name = "total_horas_trabalhadas")
	private Long horasTrabalhadasMes;

	@OneToMany(mappedBy = "garcom", cascade = CascadeType.ALL)
	private List<Ponto> pontos = new ArrayList<>();

	@Column(name = "teve_falta")
	private Boolean teveFalta;

	@OneToMany(mappedBy = "garcomComanda", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Comanda> comandas = new TreeSet<>();

	@ManyToMany
	private List<Permissao> permissoes = new ArrayList<>();

	public Garcom(Long id, String fullName, String email, Long cpf, Boolean accountNonExpired, Boolean accountNonLocked,
			Boolean credentialsNonExpired, Boolean enabled, String username, String password,
			List<Permissao> permissoes,  Double salario, Long horasTrabalhadasMes, List<Ponto> pontos,
			Boolean teveFalta, Set<Comanda> comandas, List<Permissao> permissoes2) {
		super(id, fullName, email, cpf, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, username,
				password, permissoes);
		this.salario = salario;
		this.horasTrabalhadasMes = horasTrabalhadasMes;
		this.pontos = pontos;
		this.teveFalta = teveFalta;
		this.comandas = comandas;
		permissoes = permissoes2;
	}
	
	public Garcom() {
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return super.getFullName();
	}

	@Override
	public Boolean getAccountNonExpired() {
		// TODO Auto-generated method stub
		return super.getAccountNonExpired();
	}

	@Override
	public void setAccountNonExpired(Boolean accountNonExpired) {
		// TODO Auto-generated method stub
		super.setAccountNonExpired(accountNonExpired);
	}

	@Override
	public Boolean getAccountNonLocked() {
		// TODO Auto-generated method stub
		return super.getAccountNonLocked();
	}

	@Override
	public void setAccountNonLocked(Boolean accountNonLocked) {
		// TODO Auto-generated method stub
		super.setAccountNonLocked(accountNonLocked);
	}

	@Override
	public Boolean getCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return super.getCredentialsNonExpired();
	}

	@Override
	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		// TODO Auto-generated method stub
		super.setCredentialsNonExpired(credentialsNonExpired);
	}

	@Override
	public Boolean getEnabled() {
		// TODO Auto-generated method stub
		return super.getEnabled();
	}

	@Override
	public void setEnabled(Boolean enabled) {
		// TODO Auto-generated method stub
		super.setEnabled(enabled);
	}

	@Override
	public void setFullName(String fullName) {
		// TODO Auto-generated method stub
		super.setFullName(fullName);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		super.setUsername(username);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public Long getCpf() {
		// TODO Auto-generated method stub
		return super.getCpf();
	}

	@Override
	public void setCpf(Long cpf) {
		// TODO Auto-generated method stub
		super.setCpf(cpf);
	}

	public List<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Long getHorasTrabalhadasMes() {
		return horasTrabalhadasMes;
	}

	public void setHorasTrabalhadasMes(Long horasTrabalhadasMes) {
		this.horasTrabalhadasMes = horasTrabalhadasMes;
	}

	public Boolean getTeveFalta() {
		return teveFalta;
	}

	public void setTeveFalta(Boolean teveFalta) {
		this.teveFalta = teveFalta;
	}

	public Set<Comanda> getComandas() {
		return comandas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(horasTrabalhadasMes, id, pontos, salario, teveFalta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Garcom other = (Garcom) obj;
		return Objects.equals(horasTrabalhadasMes, other.horasTrabalhadasMes) && Objects.equals(id, other.id)
				&& Objects.equals(pontos, other.pontos) && Objects.equals(salario, other.salario)
				&& Objects.equals(teveFalta, other.teveFalta);
	}

	@Override
	public String toString() {
		return "Garcom [id=" + id + ", salario=" + salario + ", horasTrabalhadasMes=" + horasTrabalhadasMes
				+ ", teveFalta=" + teveFalta + "]";
	}

}
