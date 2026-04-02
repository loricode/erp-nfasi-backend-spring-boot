package com.fasi.security.application.port.out.user;

import java.util.UUID;

import com.fasi.security.domain.dtos.user.UserModuleDTO;

import reactor.core.publisher.Flux;

public interface UserCustomPort{
    Flux<UserModuleDTO> getUserModules(UUID userId);
}