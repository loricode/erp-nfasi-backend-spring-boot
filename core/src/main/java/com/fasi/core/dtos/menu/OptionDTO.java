package com.fasi.core.dtos.menu;

import java.util.UUID;

public class OptionDTO {
    private UUID optionId;
    private String optionName;

    public OptionDTO(UUID optionId, String optionName) {
        this.optionId = optionId;
        this.optionName = optionName;
    }

    public UUID getOptionId() {
        return optionId;
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