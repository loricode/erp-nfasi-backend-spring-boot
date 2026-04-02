package com.fasi.security.infrastructure.persistence.repository.user;

import org.springframework.stereotype.Component;

import com.fasi.security.application.port.out.user.UserPort;
import com.fasi.security.domain.dtos.user.UserDTO;
import com.fasi.security.infrastructure.persistence.mapper.UserMapper;

import reactor.core.publisher.Mono;

@Component
public class UserRepositoryAdapter implements UserPort {

    private final UserRepository userRepository;

    public UserRepositoryAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<UserDTO> findByEmail(String email) {
        return userRepository.findByEmail(email)
                             .map(UserMapper::toDomain);
    }

    @Override
    public Mono<UserDTO> findByIdentification(String identification) {
        return userRepository.findByIdentification(identification)
                             .map(UserMapper::toDomain);
    }
}