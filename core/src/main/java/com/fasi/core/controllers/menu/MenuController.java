package com.fasi.core.controllers.menu;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasi.core.models.Menu;
import com.fasi.core.services.menu.MenuService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/core")
@CrossOrigin("*")
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/menu/submodules")
    public Mono<?> submodules(@RequestBody Menu menu) {
        return this.menuService.getSubModules(menu.moduleId());
    }
    
}