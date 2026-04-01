package com.fasi.core.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.fasi.core.utils.jwt.JwtAuthFilter;

import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    
    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
      this.jwtAuthFilter = jwtAuthFilter;
    }
    
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeExchange(exchanges -> exchanges
                        .anyExchange().authenticated()
                )
                .addFilterAt(jwtAuthFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .build();
    }
    
    
	/*@Bean
	    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		 http
         .csrf(csrf -> csrf.disable())
	            .authorizeExchange(exchanges -> exchanges
	                .anyExchange().permitAll()
	            );
	        return http.build();
	}*/
    
}
