package com.ggs.yaml.controller;

import com.ggs.yaml.entity.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Properties;

/**
 * @Author lianghaohui
 * @Date 2022/1/21 10:56
 * @Description 动态读取自定义yml配置文件
 */
@RestController
@RequestMapping("/custom")
public class AnotherYamlController {

    @Value("${person.student:null}")
    private String student;
    @Value("${person.age:null}")
    private String age;

    /**
     * 动态加载yaml配置文件
     */
    @GetMapping("fcTest")
    public R ymlProFctest() {
        YamlPropertiesFactoryBean yamlProFb = new YamlPropertiesFactoryBean();
        yamlProFb.setResources(new ClassPathResource("application2.yml"));
        Properties properties = yamlProFb.getObject();
        System.out.println(properties.get("person.student"));
        System.out.println(properties.get("person.age"));
        System.out.println(properties);
        return R.ok().data(Arrays.asList(properties.get("person.student"), properties.get("person.age")));
    }

    @GetMapping("fcTest2")
    public R ymlProFctest2() {
        System.out.println(student);
        System.out.println(age);
        return R.ok().data(Arrays.asList(student, age));
    }

}
