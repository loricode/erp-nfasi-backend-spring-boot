package com.fasi.core.persistence.menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;

import com.fasi.core.dtos.menu.MenuDTO;
import com.fasi.core.dtos.menu.MenuFlatDTO;
import com.fasi.core.dtos.menu.OptionDTO;
import com.fasi.core.repositories.menu.MenuCustomRepository;

import reactor.core.publisher.Mono;

@Repository
public class MenuCustomRepositoryImpl implements MenuCustomRepository {

    private final DatabaseClient databaseClient;

    public MenuCustomRepositoryImpl(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @Override
    public Mono<List<MenuDTO>> getModuleMenu(UUID moduleId) {

        return databaseClient
                .sql("SELECT * FROM get_module_menu_flat(:moduleId)")
                .bind("moduleId", moduleId)
                .map((row, metadata) -> new MenuFlatDTO(
                        row.get("submodule_id", UUID.class),
                        row.get("submodule_name", String.class),
                        row.get("option_id", UUID.class),
                        row.get("option_name", String.class)))
                .all()
                .collectList()
                .map(this::groupMenu);
    }

    private List<MenuDTO> groupMenu(List<MenuFlatDTO> flatList) {

    Map<UUID, MenuDTO> map = new LinkedHashMap<>();

    for (MenuFlatDTO row : flatList) {

        map.putIfAbsent(
                row.getSubmoduleId(),
                new MenuDTO(
                        row.getSubmoduleId(),
                        row.getSubmoduleName(),
                        new ArrayList<>()
                )
        );

        if (row.getOptionId() != null) {
            map.get(row.getSubmoduleId())
                    .getOptions()
                    .add(new OptionDTO(row.getOptionId(), row.getOptionName()));
        }
    }

    return new ArrayList<>(map.values());
}


}
