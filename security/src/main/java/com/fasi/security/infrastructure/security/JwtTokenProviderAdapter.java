package com.fasi.security.infrastructure.security;

import org.springframework.stereotype.Component;

import com.fasi.security.application.port.out.security.TokenProviderPort;
import com.fasi.erp.security.JwtUtil;

@Component
public class JwtTokenProviderAdapter implements TokenProviderPort {

    private final JwtUtil jwtUtil;

    public JwtTokenProviderAdapter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public String generateToken(String email) {
        return jwtUtil.generateToken(email);
    }

  
    public boolean isTokenValid(String token) {
        return jwtUtil.isTokenValid(token);
    }

    public String getEmailFromToken(String token) {
        return jwtUtil.getEmailOfToken(token);
    }
}
