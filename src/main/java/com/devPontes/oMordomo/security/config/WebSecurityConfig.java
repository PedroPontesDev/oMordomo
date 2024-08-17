package com.devPontes.oMordomo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		http.csrf((csrf) -> csrf.disable())
				.authorizeHttpRequests(
						(httpRequest) -> httpRequest.requestMatchers(HttpMethod.POST, "/login/**").permitAll())
				.authorizeHttpRequests((httpRequest) -> httpRequest.requestMatchers("/api/**/controle-ponto")
						.hasAuthority("ADMIN").anyRequest().authenticated())
				.authorizeHttpRequests((httpRequest) -> httpRequest.requestMatchers("/api/**/garcom")
						.hasAuthority("GARCOM").anyRequest().hasAuthority("ADMIN"));

		return http.build();

	}

}
