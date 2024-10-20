package com.ntd.operationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.ntd.operationservice")
@SpringBootApplication
@EnableJpaRepositories("com.ntd.operationservice")
@EntityScan("com.ntd.operationservice")
public class OperationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperationServiceApplication.class, args);
	}

}
