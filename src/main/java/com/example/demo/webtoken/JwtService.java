package com.example.demo.webtoken;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET= "A6654D19A830581B39D231B1C64858E6902833733217CE72EDBD40FAA4B643C679814FBED4F6DB15C61DD53B81B4231782D2E99DDD7DA966EE5AA8B94F7A3090";
    private static final long VALIDITY = TimeUnit.MINUTES.toMillis(30);

    public String generateToken(UserDetails userDetails)
    {
        Map<String,String> claims = new HashMap<>();
        claims.put("iss","https://consultadd.com");
        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusMillis(VALIDITY)))
                .signWith(generateKey())
                .compact();

    }

    private SecretKey generateKey() {
        byte[] decodedKey= Base64.getDecoder().decode(SECRET);
        return Keys.hmacShaKeyFor(decodedKey);
    }

    public String extractUsername(String jwt) {
        Claims claims=getClaims(jwt);
        return claims.getSubject();
    }

    private Claims getClaims(String jwt) {
        return Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();

    }

    public boolean isTokenValid(String jwt) {
        Claims claims=getClaims(jwt);
        return claims.getExpiration().after(Date.from(Instant.now()));
    }
}
