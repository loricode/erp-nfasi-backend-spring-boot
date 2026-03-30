package com.fasi.seguridad.services.auth;

import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

import com.fasi.erp.security.JwtUtil;
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

                return userCustomRepository.getUserModules(user.getId())
                        .collectList()
                        .map(modules -> Map.of(
                                "token", token,
                                "email", user.getEmail(),
                                "modules", modules
                        ));
            });
    }
    
}
