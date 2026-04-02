package com.fasi.security.domain.dtos.user;

import java.util.UUID;

public class UserModuleDTO{

    private UUID moduleId;
    private String moduleName;
    private String route;
    private String icon;

    public UserModuleDTO(UUID moduleId, String moduleName, String route, String icon) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.route = route;
        this.icon = icon;
    }

	public UUID getModuleId() {
		return moduleId;
	}

	public void setModuleId(UUID moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

    // getters
}