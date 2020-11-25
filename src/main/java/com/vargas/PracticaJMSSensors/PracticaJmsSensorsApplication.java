package com.vargas.PracticaJMSSensors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PracticaJmsSensorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaJmsSensorsApplication.class, args);
	}

}
