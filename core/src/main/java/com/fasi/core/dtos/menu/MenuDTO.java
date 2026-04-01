package com.fasi.core.dtos.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MenuDTO {
    private UUID submoduleId;
    private String submoduleName;
    private List<OptionDTO> options = new ArrayList<>();
    
    public MenuDTO(UUID submoduleId, String submoduleName, List<OptionDTO> options) {
        this.submoduleId = submoduleId;
        this.submoduleName = submoduleName;
        this.options = options;
    }
    public UUID getSubmoduleId() {
        return submoduleId;
    }
    public void setSubmoduleId(UUID submoduleId) {
        this.submoduleId = submoduleId;
    }
    public String getSubmoduleName() {
        return submoduleName;
    }
    public void setSubmoduleName(String submoduleName) {
        this.submoduleName = submoduleName;
    }
    public List<OptionDTO> getOptions() {
        return options;
    }
    public void setOptions(List<OptionDTO> options) {
        this.options = options;
    }
   
}
