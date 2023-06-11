package com.example.registrationlogindemo.config;

import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    
    @Value("${swagger.server.ip:127.0.0.1}")
    private String SERVER_IP;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .protocols(Set.of("http", "https"))
                .host(SERVER_IP).select().apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.example.registrationlogindemo")).paths(PathSelectors.any()).build();
    }
}