package com.test.spring.SpringBootBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBankApplication.class, args);
	}
}
