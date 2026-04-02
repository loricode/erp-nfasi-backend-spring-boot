package com.fasi.security.application.port.out.security;

public interface TokenProviderPort{
	String generateToken(String email);
    boolean isTokenValid(String token);
    String getEmailFromToken(String token);
}
