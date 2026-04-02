package com.fasi.security.application.usecase.auth;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.fasi.security.application.port.out.security.TokenProviderPort;

import java.util.Map;

@Service
public class ValidateTokenUseCase {

    private final TokenProviderPort tokenProvider;

    public ValidateTokenUseCase(TokenProviderPort tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    public Mono<Map<String, Object>> execute(String header) {

        if (header == null || !header.startsWith("Bearer ")) {
            return Mono.just(Map.of(
                    "valid", false,
                    "message", "Token no proporcionado"
            ));
        }

        String token = header.substring(7);

        boolean isValid = tokenProvider.isTokenValid(token);

        if (!isValid) {
            return Mono.just(Map.of(
                    "valid", false,
                    "message", "Token inválido o expirado"
            ));
        }

        return Mono.just(Map.of(
                "valid", true,
                "message", "Token válido"
        ));
    }
}