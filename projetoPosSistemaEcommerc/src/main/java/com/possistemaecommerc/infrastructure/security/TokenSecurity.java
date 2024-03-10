package com.possistemaecommerc.infrastructure.security;

import com.possistemaecommerc.filters.JWTAuthenticationFilter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenSecurity {
//    @Value("$jwt.secret")
//    private String jwtSecret;

    public static String generateToken(String email){

        // chave secreta para geração
//do TOKEN (Evitar falsificações)
        String secretKey = JWTAuthenticationFilter.SECRET;


         String token = Jwts.builder()
                .setSubject(email) //email do usuário
                .setIssuedAt(new Date()) //data da geração
                .signWith(SignatureAlgorithm.HS256,secretKey.getBytes()) //chave antifalsificação
                .compact();
        return token;
    }
}
