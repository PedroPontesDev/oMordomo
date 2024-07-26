package com.devPontes.oMordomo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {


	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
					.info(new Info()
							.title("Gerenciador de Restaurantes - O Mordomo")
							.version("v1")
							.description("Um webservcice que provê diversas funcionalidas para gerenciar restaurantes de todos os portes!"));
							
	}
	
}
