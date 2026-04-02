package com.fasi.security.presentation.controllers.auth;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasi.security.application.usecase.auth.LoginUseCase;
import com.fasi.security.domain.models.User;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/security/auth")
public class AuthController {

    private LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public Mono<?> login(@RequestBody User user) {
        return loginUseCase.execute(user.email(), user.password())
                .onErrorResume(e -> Mono.just(
                        Map.of("error", e.getMessage())
                ));
    }
    

}