package com.devPontes.oMordomo.security.services.jwt;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.devPontes.oMordomo.model.entities.Usuario;

@Component
public class JwtTokenProvider {
	
	@Value("${security.jwt.token.secret-key}")	
	private String  secret;
	
	@Value("${security.jwt.token.expire-length}")
	private long jwtExpirationMs;
	
	public String generateToken(UserDetails userDetails) { // Gerador de token
		try{
			
			Algorithm alg = Algorithm.HMAC512(secret);

			String token = JWT.create()
							  .withIssuer("o-mordomo-webservice")
							  .withSubject(userDetails.getUsername())
							  .withExpiresAt(this.expirationDate())
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
	
	private Instant expirationDate() {
		return Instant.now().plusSeconds(jwtExpirationMs);
	}

}
	