package com.fasi.core.application.usecase.menu;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasi.core.application.port.out.menu.MenuCustomPort;
import com.fasi.core.domain.dtos.menu.MenuDTO;
import com.fasi.core.presentation.exception.ApiException;

import reactor.core.publisher.Mono;

@Service
public class GetSubModulesUseCase {
    private final MenuCustomPort menuCustomRepository;

    public GetSubModulesUseCase(MenuCustomPort menuCustomRepository) {
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
