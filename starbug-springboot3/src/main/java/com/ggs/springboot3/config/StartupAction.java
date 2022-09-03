package com.ggs.springboot3.config;

import com.ggs.springboot3.entity.RandomDataEntity;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupAction implements CommandLineRunner {

    @Autowired
    private RandomDataEntity randomDataEntity;

    @Autowired
    private Gson gson;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(gson.toJson(randomDataEntity));
    }

}
