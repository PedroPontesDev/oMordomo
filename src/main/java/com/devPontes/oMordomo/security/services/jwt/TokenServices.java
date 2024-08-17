package com.devPontes.oMordomo.security.services.jwt;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAmount;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.devPontes.oMordomo.model.entities.Usuario;

@Service
public class TokenServices {
	
	@Value("${security.jwt.token.secret-key}")	
	private String  secret;
	
	
	
	public String generateToken(Usuario usuario) { // Gerador de token
		try{
			
			Algorithm alg = Algorithm.HMAC512(secret);

			String token = JWT.create()
							  .withIssuer("o-mordomo-webservice")
							  .withSubject(usuario.getUsername())
							  .withExpiresAt(this.expirantionDate())
							  .sign(alg);
			return token;
		}catch(JWTCreationException exception) {
			throw new RuntimeException("Erro na tentantativa de autenticação!");
		}
	}
	
	public String validateToken(String token) { //Validador de token
		try {
			Algorithm alg = Algorithm.HMAC512(secret);
			return JWT.require(alg)
					.withIssuer("o-mordomo-webservice")
					.build()
					.verify(token).getSubject();
					
					
		}catch(JWTVerificationException e) {
			return null;
		}
	}
	
	private Instant expirantionDate() {
		return Instant.now().plusSeconds(3600000);
	}

}
	