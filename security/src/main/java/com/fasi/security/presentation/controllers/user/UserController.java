package com.fasi.security.presentation.controllers.user;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasi.security.application.usecase.auth.GetModulesUseCase;
import com.fasi.security.application.usecase.auth.ValidateTokenUseCase;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/security/user")
public class UserController {

	private final ValidateTokenUseCase validateTokenUseCase;
    private final GetModulesUseCase getModulesUseCase;
	
    public UserController(ValidateTokenUseCase validateTokenUseCase,
    		GetModulesUseCase getModulesUseCase
    		) {
        this.validateTokenUseCase = validateTokenUseCase;
        this.getModulesUseCase = getModulesUseCase;
    }
    
    @GetMapping("/validate")
    public Mono<?> validateToken(@RequestHeader("Authorization") String header) {
        return validateTokenUseCase.execute(header);
    }
    
    @GetMapping("/module/{userId}")
    public Mono<?> getUserModules(@PathVariable("userId") UUID userId) {
        return getModulesUseCase.execute(userId);
    }
    
}
