package com.ggs.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ggs.product.mapper")
public class StarbugProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarbugProductApplication.class, args);
    }

}
