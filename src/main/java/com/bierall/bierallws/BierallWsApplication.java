package com.bierall.bierallws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories
public class BierallWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BierallWsApplication.class, args);
	}
}
