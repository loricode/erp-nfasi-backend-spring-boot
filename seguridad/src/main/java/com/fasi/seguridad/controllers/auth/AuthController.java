package com.fasi.seguridad.controllers.auth;

import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasi.seguridad.models.User;
import com.fasi.seguridad.services.auth.AuthService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Mono<?> login(@RequestBody User user) {
        return authService.login(user.email(), user.password())
                .onErrorResume(e -> Mono.just(
                        Map.of("error", e.getMessage())
                ));
    }
    
    
    
    
    
    
    @GetMapping("/crear")
    public void login() {
    	System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}