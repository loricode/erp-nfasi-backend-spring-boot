package com.fasi.security.application.port.out.user;

import com.fasi.security.domain.dtos.user.UserDTO;

import reactor.core.publisher.Mono;

public interface UserPort{
    Mono<UserDTO> findByEmail(String email);

    Mono<UserDTO> findByIdentification(String identification);
}
