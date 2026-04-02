package com.fasi.security.infrastructure.persistence.mapper;

import com.fasi.security.domain.dtos.user.*;
import com.fasi.security.infrastructure.entity.UserEntity;

public class UserMapper {

   public static UserDTO toDomain(UserEntity entity) {
        if (entity == null) return null;

        UserDTO user = new UserDTO();
        user.setId(entity.getId());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        user.setFullName(entity.getFullName());
        user.setIdentification(entity.getIdentification());
        user.setRole(entity.getRole());
        return user;
    }


    public static UserEntity toEntity(UserDTO user) {
        if (user == null) return null;

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setFullName(user.getFullName());
        entity.setIdentification(user.getIdentification());
        entity.setRole(user.getRole());
        return entity;
    }
}
