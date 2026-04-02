package com.fasi.security.domain.dtos.auth;

import java.util.List;

import com.fasi.security.domain.dtos.user.UserModuleDTO; 


public class LoginResponseDTO {
	private String token;
    private String email;
    private List<UserModuleDTO> modules;

    public LoginResponseDTO(String token, String email, List<UserModuleDTO> modules) {
        this.token = token;
        this.email = email;
        this.modules = modules;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<UserModuleDTO> getModules() {
		return modules;
	}

	public void setModules(List<UserModuleDTO> modules) {
		this.modules = modules;
	}
    
    
}