package com.fasi.seguridad.services.auth;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

import com.fasi.erp.security.JwtUtil;
import com.fasi.seguridad.dtos.user.UserModuleDTO;
import com.fasi.seguridad.repositories.user.UserCustomRepository;
import com.fasi.seguridad.repositories.user.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final UserCustomRepository userCustomRepository;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwtUtil;
    
    public AuthService(UserRepository userRepository,
    		UserCustomRepository userCustomRepository,
                       BCryptPasswordEncoder encoder,
                       JwtUtil jwtUtil
                       ) {
        this.userRepository = userRepository;
        this.userCustomRepository = userCustomRepository;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public Mono<Map<String, Object>> login(String email, String password) {

        return userRepository.findByEmail(email)
            .switchIfEmpty(Mono.error(new RuntimeException("Usuario no encontrado")))
            
            .filter(user -> encoder.matches(password, user.getPassword()))
            .switchIfEmpty(Mono.error(new RuntimeException("Credenciales inválidas")))
            
            .flatMap(user -> {
                String token = jwtUtil.generateToken(user.getEmail());

                return Mono.just(Map.of(
                        "token", token,
                        "email", user.getEmail(),
                        "userId", user.getId()
                ));
            });
    }
    
    public Mono<List<UserModuleDTO>> getModules(UUID userId) {
        return userCustomRepository
                .getUserModules(userId)
                .collectList();           
    }
    
    
    public Mono<Map<String, Object>> validateToken(String header) {

        if (header == null || !header.startsWith("Bearer ")) {
            return Mono.just(Map.of(
                    "valid", false,
                    "message", "Token no proporcionado"
            ));
        }

        String token = header.substring(7);

        boolean isValid = jwtUtil.isTokenValid(token);

        if (!isValid) {
            return Mono.just(Map.of(
                    "valid", false,
                    "message", "Token inválido o expirado"
            ));
        }
        
        return Mono.just(Map.of(
                "valid", true,
                "message", "Token valido"
        ));
        
    }
    
    
}
