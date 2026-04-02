package com.fasi.erp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Configuration
@EnableConfigurationProperties(JwtProperties.class)
public class JwtAutoConfig {

   @Autowired
   private JwtProperties props;

   @Bean
   JwtUtil jwtUtil() {
       
       if (props.getSecret() == null || props.getSecret().isBlank()) {
           throw new IllegalStateException("jwt.secret must be defined in application.properties");
       }
       return new JwtUtil(props);
   }
}