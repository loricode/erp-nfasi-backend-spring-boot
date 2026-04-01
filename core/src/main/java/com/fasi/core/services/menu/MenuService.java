package com.fasi.core.services.menu;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fasi.core.dtos.menu.MenuDTO;
import com.fasi.core.repositories.menu.MenuCustomRepository;

import reactor.core.publisher.Mono;

@Service
public class MenuService {
    private final MenuCustomRepository menuCustomRepository;

    public MenuService(MenuCustomRepository menuCustomRepository) {
        this.menuCustomRepository = menuCustomRepository;
    }

    public Mono<List<MenuDTO>> getSubModules(UUID moduleId){
     return menuCustomRepository.getModuleMenu(moduleId);
   }
}
