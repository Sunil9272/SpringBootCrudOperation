package com.springboot.springbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.springboot.springbootapplication.controller")
@EnableJpaRepositories(basePackages = "com.springboot.springbootapplication.repository")

public class SpringbootapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootapplicationApplication.class, args);
	}

}
