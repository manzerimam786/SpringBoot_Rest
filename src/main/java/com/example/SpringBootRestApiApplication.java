package com.example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = "com.atish")
//@EnableCaching
@OpenAPIDefinition(info = @Info(title = "My API", version = "v1"))
public class SpringBootRestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiApplication.class, args);
    }
}
