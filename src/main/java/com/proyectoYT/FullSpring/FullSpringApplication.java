package com.proyectoYT.FullSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FullSpringApplication {

	private static Logger logger = LoggerFactory.getLogger(FullSpringApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(FullSpringApplication.class, args);

		logger.debug("Mi mensaje debug");
	}

}
