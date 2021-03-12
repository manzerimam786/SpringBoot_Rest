package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableAutoConfiguration
//@EnableJpaRepositories(basePackages="com.example.dao", entityManagerFactoryRef="emf")
public class SpringBootRestApiApplication //extends SpringBootServletInitializer
{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApplication.class, args);
	}
	/*
	 * public void run(String args)throws Exception { RestTemplate restTemplate =
	 * new RestTemplate();
	 * restTemplate.getForObject("http://localhost:8081/rabbitmq/sendMsg/soap",
	 * null); }
	 */
}
