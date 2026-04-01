package com.fasi.core.dtos.menu;

import java.util.UUID;

public class MenuFlatDTO {

    private UUID submoduleId;
    private String submoduleName;
    private UUID optionId;
    private String optionName;

    public MenuFlatDTO(UUID submoduleId, String submoduleName, UUID optionId, String optionName) {
        this.submoduleId = submoduleId;
        this.submoduleName = submoduleName;
        this.optionId = optionId;
        this.optionName = optionName;
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
