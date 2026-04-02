package com.fasi.security.application.usecase.auth;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fasi.security.application.port.out.user.UserCustomPort;
import com.fasi.security.domain.dtos.user.UserModuleDTO;

import reactor.core.publisher.Mono;

@Service
public class GetModulesUseCase {

    private final UserCustomPort userCustomPort;

    public GetModulesUseCase(UserCustomPort userCustomPort) {
        this.userCustomPort = userCustomPort;
    }

    public Mono<List<UserModuleDTO>> execute(UUID userId) {
        return userCustomPort.getUserModules(userId)
                             .collectList();
    }
}
