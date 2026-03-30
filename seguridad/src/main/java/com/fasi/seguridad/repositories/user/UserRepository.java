package com.fasi.seguridad.repositories.user;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.fasi.seguridad.entities.user.User;

import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRepository extends ReactiveCrudRepository<User, UUID>  {

    Mono<User> findByEmail(String username);

    Mono<User> findByIdentification(String identification);
}