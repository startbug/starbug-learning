package com.ggs.starbugcron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
@SpringBootApplication
public class StarbugCronApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarbugCronApplication.class, args);
    }

}
