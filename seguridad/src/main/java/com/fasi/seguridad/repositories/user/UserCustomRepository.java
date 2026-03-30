package com.fasi.seguridad.repositories.user;

import java.util.UUID;

import com.fasi.seguridad.dtos.user.UserModuleDTO;

import reactor.core.publisher.Flux;

public interface UserCustomRepository {
    Flux<UserModuleDTO> getUserModules(UUID userId);
}