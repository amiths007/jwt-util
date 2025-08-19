package com.auth.jwt.service;

import com.auth.jwt.model.JwtRequest;
import com.auth.jwt.model.JwtResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public JwtResponse jwtResponse(JwtRequest request) {

        String token = getToken(request);

        return JwtResponse.builder()
                .issuedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)))
                .expiration(System.currentTimeMillis() + 60 * 30)
                .accessToken(token)
                .build();

    }

    public String getToken(JwtRequest request) {

        return Jwts.builder()
                .setClaims(setClaims(request))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 2000))
                .signWith(getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }

    private Map<String, String> setClaims(JwtRequest request) {
        return Map.of("alg", request.getAlg(),
                "aud", request.getAud(),
                "typ", request.getTyp());
    }

    private PrivateKey getPrivateKey() {

        try {

            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048); // 2048-bit key
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            return keyPair.getPrivate();
        } catch (Exception ex) {

            throw new RuntimeException("Error generating private key");
        }

    }


}
