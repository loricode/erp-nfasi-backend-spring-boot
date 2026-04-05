package com.fasi.core.presentation.controllers.menu;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasi.core.application.usecase.menu.GetSubModulesUseCase;
import com.fasi.core.domain.models.Menu;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/core")
public class MenuController {

    private GetSubModulesUseCase subMenuUseCase;

    public MenuController(GetSubModulesUseCase menuService) {
        this.subMenuUseCase = menuService;
    }

    @PostMapping("/menu/submodules")
    public Mono<?> submodules(@RequestBody Menu menu) {
        return this.subMenuUseCase.execute(menu.moduleId());
    }
    
}