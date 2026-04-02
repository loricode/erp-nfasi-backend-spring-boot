package com.fasi.security.infrastructure.persistence.repository.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.fasi.security.application.port.out.security.PasswordEncoderPort;

@Component
public class BCryptPasswordEncoderAdapter implements PasswordEncoderPort {

    private final BCryptPasswordEncoder encoder;

    public BCryptPasswordEncoderAdapter() {
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public boolean matches(String rawPassword, String encoded) {
        return encoder.matches(rawPassword, encoded);
    }
}
