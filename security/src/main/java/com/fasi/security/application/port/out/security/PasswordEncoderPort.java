package com.fasi.security.application.port.out.security;



public interface PasswordEncoderPort{
	boolean matches(String rawPassword, String encoded);
}
