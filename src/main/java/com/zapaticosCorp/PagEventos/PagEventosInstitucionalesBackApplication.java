package com.zapaticosCorp.PagEventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PagEventosInstitucionalesBackApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PagEventosInstitucionalesBackApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(PagEventosInstitucionalesBackApplication.class, args);
	}


}

