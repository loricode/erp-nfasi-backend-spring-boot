package com.fasi.erp.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private final Key key;
    private final long expiration;

    public JwtUtil(JwtProperties props) {
        this.key = Keys.hmacShaKeyFor(props.getSecret().getBytes());
        this.expiration = props.getExpiration();
    }

    public String generateTokenWithRole(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    
    public String getEmailOfToken(String token) {
        return getClaims(token).getSubject();
    }
    
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    
    public String generateToken(String correo) {
        return Jwts.builder()
                .setSubject(correo)
                .claim("correo", correo)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims validate(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    
    public boolean isTokenValid(String token) {
        try {
            validate(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}