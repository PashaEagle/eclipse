package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Jdbc2MysqlCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jdbc2MysqlCrudApplication.class, args);
	}
}
