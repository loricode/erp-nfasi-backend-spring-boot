package com.fasi.core.services.menu;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasi.core.dtos.menu.MenuDTO;
import com.fasi.core.repositories.menu.MenuCustomRepository;
import com.fasi.core.utils.customError.ApiException;

import reactor.core.publisher.Mono;

@Service
public class MenuService {
    private final MenuCustomRepository menuCustomRepository;

    public MenuService(MenuCustomRepository menuCustomRepository) {
        this.menuCustomRepository = menuCustomRepository;
    }

    public Mono<List<MenuDTO>> getSubModules(UUID moduleId){
    	
    	if (moduleId == null) {
            return Mono.error(new ApiException(
                HttpStatus.BAD_REQUEST,
                "ID de módulo inválido",
                "moduleId no puede ser null"
            ));
        }
    	
     return menuCustomRepository.getModuleMenu(moduleId)
    		    .switchIfEmpty(Mono.error(new ApiException(
             HttpStatus.NOT_FOUND,
             "Módulos no encontrado",
             "ID: " + moduleId
         )));
    }
}
