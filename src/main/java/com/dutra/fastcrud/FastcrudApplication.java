package com.dutra.fastcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FastcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastcrudApplication.class, args);
	}

}
