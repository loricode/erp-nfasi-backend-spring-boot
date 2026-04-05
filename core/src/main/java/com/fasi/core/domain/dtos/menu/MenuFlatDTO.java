package com.fasi.core.domain.dtos.menu;

import java.util.UUID;

public class MenuFlatDTO {

    private UUID submoduleId;
    private String submoduleName;
    private UUID optionId;
    private String optionName;
    private String icon;
    private String route;

    public MenuFlatDTO(
        UUID submoduleId,
        String submoduleName, 
        UUID optionId, 
        String optionName, 
        String icon, 
        String route
    ) {
        this.submoduleId = submoduleId;
        this.submoduleName = submoduleName;
        this.optionId = optionId;
        this.optionName = optionName;
        this.icon = icon;
        this.route = route;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

     public String getRoute() {
        return route;
    }

    public void setRoute(String route){
        this.route = route;
    }

    public UUID getSubmoduleId() {
        return submoduleId;
    }

    public String getSubmoduleName() {
        return submoduleName;
    }

    public UUID getOptionId() {
        return optionId;
    }

    public String getOptionName() {
        return optionName;
    }
}
