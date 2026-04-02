package com.fasi.core.application.port.out.menu;

import java.util.List;
import java.util.UUID;

import com.fasi.core.domain.dtos.menu.MenuDTO;

import reactor.core.publisher.Mono;

public interface MenuCustomPort {
    Mono<List<MenuDTO>> getModuleMenu(UUID userId);
}
