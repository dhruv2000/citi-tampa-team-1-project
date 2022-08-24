package com.citi.project.team1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
@ComponentScan
public class AppConfig {
    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class);
    }
}
