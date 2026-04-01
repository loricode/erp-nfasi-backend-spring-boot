package com.fasi.core.repositories.menu;

import java.util.List;
import java.util.UUID;

import com.fasi.core.dtos.menu.MenuDTO;

import reactor.core.publisher.Mono;

public interface MenuCustomRepository {
    Mono<List<MenuDTO>> getModuleMenu(UUID userId);
}
