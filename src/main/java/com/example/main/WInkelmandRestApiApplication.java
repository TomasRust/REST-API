package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.example")

@EntityScan
@ComponentScan("com.example")
//@EnableJpaRepositories(basePackages = { "com.example.accessingdatamysql"})
public class WInkelmandRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WInkelmandRestApiApplication.class, args);
	}

}
