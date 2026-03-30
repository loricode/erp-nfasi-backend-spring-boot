package com.fasi.seguridad.persistence.user;

import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;

import com.fasi.seguridad.dtos.user.UserModuleDTO;
import com.fasi.seguridad.repositories.user.UserCustomRepository;

import reactor.core.publisher.Flux;
import java.util.UUID;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    private final DatabaseClient databaseClient;

    public UserCustomRepositoryImpl(DatabaseClient databaseClient) {
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