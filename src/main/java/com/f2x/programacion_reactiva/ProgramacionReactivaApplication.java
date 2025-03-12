package com.f2x.programacion_reactiva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgramacionReactivaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramacionReactivaApplication.class, args);
		String password = System.getenv("DB_PASSWORD");
		System.out.println("Valor de DB_PASSWORD: " + password);
	}

}
