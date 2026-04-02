package com.fasi.security.infrastructure.persistence.repository.user;

import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;

import com.fasi.security.application.port.out.user.UserCustomPort;
import com.fasi.security.domain.dtos.user.UserModuleDTO;

import reactor.core.publisher.Flux;
import java.util.UUID;

@Repository
public class UserCustomRepositoryAdapter implements UserCustomPort {

    private final DatabaseClient databaseClient;

    public UserCustomRepositoryAdapter(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @Override
    public Flux<UserModuleDTO> getUserModules(UUID userId) {
        return databaseClient
                .sql("SELECT * FROM get_user_modules(:userId)")
                .bind("userId", userId)
                .map((row, metadata) -> new UserModuleDTO(
                        row.get("module_id", UUID.class),
                        row.get("module_name", String.class),
                        row.get("route", String.class),
                        row.get("icon", String.class)
                ))
                .all();
    }
}