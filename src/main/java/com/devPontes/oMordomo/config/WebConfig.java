package com.devPontes.oMordomo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

	@Value("${cors.originPatterns:default}")
	private String corsOriginPatterns = "";

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(false)
					.ignoreAcceptHeader(false)
					.mediaType("pdf", MediaType.APPLICATION_PDF)
					.mediaType("xml", MediaType.APPLICATION_XML)
					.defaultContentType(MediaType.APPLICATION_JSON);
					
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping(corsOriginPatterns);
	}
	
	
	
}
