package com.fasi.seguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.fasi.seguridad", "com.fasi.erp.security" })
public class SeguridadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeguridadApplication.class, args);
	}

}
