package com.fasi.security.infrastructure.persistence.repository.user;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.fasi.security.infrastructure.entity.UserEntity;

import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, UUID>  {

    Mono<UserEntity> findByEmail(String username);

    Mono<UserEntity> findByIdentification(String identification);
}