package com.fasi.seguridad.controllers.user;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasi.seguridad.services.auth.AuthService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/security/user")
@CrossOrigin("*")
public class UserController {

	private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }
    
    @GetMapping("/validate")
    public Mono<?> validateToken(@RequestHeader("Authorization") String header) {
        return authService.validateToken(header);
    }
    
    @GetMapping("/module/{userId}")
    public Mono<?> getUserModules(@PathVariable UUID userId) {
        return authService.getModules(userId);
    }
    
}
