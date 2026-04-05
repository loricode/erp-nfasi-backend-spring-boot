package com.fasi.core.domain.dtos.menu;

import java.util.UUID;

public class OptionDTO {
    private UUID optionId;
    private String optionName;
    private String icon;
    private String route;
    
    public OptionDTO(UUID optionId, String optionName, String icon, String route) {
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

    public UUID getOptionId() {
        return optionId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route){
        this.route = route;
    }

    public void setOptionId(UUID optionId) {
        this.optionId = optionId;
    }
    public String getOptionName() {
        return optionName;
    }
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}