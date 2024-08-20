package com.devPontes.oMordomo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
        http
        .httpBasic((basic) -> basic.disable())
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> {
                auth.requestMatchers(HttpMethod.POST, "/api/v1/login/**").permitAll();
                auth.requestMatchers("/api/v1/mesas/**").hasAnyAuthority("ROLE_GARCOM", "ROLE_ADMIN", "ROLE_CLIENTE");
                auth.requestMatchers("/api/v1/garcom/**").hasAnyAuthority("ROLE_GARCOM", "ROLE_ADMIN");
                auth.requestMatchers("/api/v1/comanda/**").hasAnyAuthority("ROLE_GARCOM", "ROLE_ADMIN");
                auth.requestMatchers("/api/v1/controle-ponto/**").hasAnyAuthority("ROLE_ADMIN");
                auth.anyRequest().authenticated();
            })
        ;return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
