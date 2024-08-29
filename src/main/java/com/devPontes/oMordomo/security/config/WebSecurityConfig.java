package com.devPontes.oMordomo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import com.devPontes.oMordomo.security.services.jwt.JwtAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter)
			throws Exception {
		http.httpBasic(basic -> basic.disable())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //Sesssões stateless
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> {
			auth.requestMatchers(HttpMethod.POST, "/api/v1/auth/register-admin").fullyAuthenticated();
			auth.requestMatchers(HttpMethod.POST, "/api/v1/auth/login").permitAll();
			auth.requestMatchers("/api/v1/mesas/**").hasAnyAuthority("ROLE_GARCOM", "ROLE_ADMIN", "ROLE_CLIENTE");
			auth.requestMatchers("/api/v1/garcom/**").hasAnyAuthority("ROLE_GARCOM", "ROLE_ADMIN");
			auth.requestMatchers("/api/v1/comanda/**").hasAnyAuthority("ROLE_GARCOM", "ROLE_ADMIN");
			auth.requestMatchers("/api/v1/controle-ponto/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_GERENTE");
		}).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // Adiciona uma cadeia de filtro antes das requisições 

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	}
}
