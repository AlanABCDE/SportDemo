package com.noob.sportsdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.noob.sportsdemo.mapper")
@MapperScan("com.noob.sportsdemo.service.impl")
public class SportsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsDemoApplication.class, args);
    }

}
