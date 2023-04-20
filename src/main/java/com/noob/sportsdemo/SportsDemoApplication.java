package com.noob.sportsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableSwagger2WebMvc
public class SportsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsDemoApplication.class, args);
    }
}