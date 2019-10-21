package com.lifei.mood;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.lifei.mood.mapper")
public class MoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoodApplication.class, args);
    }

}
