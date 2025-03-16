package com.dac.sanus_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SanusApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanusApiApplication.class, args);
	}

}
