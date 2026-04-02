package com.fasi.security.application.usecase.auth;

import reactor.core.publisher.Mono;

import com.fasi.security.application.port.out.security.PasswordEncoderPort;
import com.fasi.security.application.port.out.security.TokenProviderPort;
import com.fasi.security.application.port.out.user.UserPort;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class LoginUseCase{

    private final UserPort userPort;
    private final PasswordEncoderPort passwordEncoder;
    private final TokenProviderPort tokenProvider;

    public LoginUseCase(UserPort userPort,
    		PasswordEncoderPort passwordEncoder,
    		TokenProviderPort tokenProvider) {
        this.userPort = userPort;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    public Mono<Map<String, Object>> execute(String email, String password) {
        return userPort.findByEmail(email)
            .switchIfEmpty(Mono.error(new RuntimeException("Usuario no encontrado")))
            .filter(user -> passwordEncoder.matches(password, user.getPassword()))
            .switchIfEmpty(Mono.error(new RuntimeException("Credenciales inválidas")))
            .flatMap(user -> {
                String token = tokenProvider.generateToken(user.getEmail());
                return Mono.just(Map.of(
                        "token", token,
                        "email", user.getEmail(),
                        "userId", user.getId()
                ));
            });
    }
}