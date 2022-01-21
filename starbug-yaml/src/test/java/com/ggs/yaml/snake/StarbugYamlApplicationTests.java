package com.ggs.yaml.snake;

import com.ggs.yaml.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.Map;

/**
 * 测试snakeyaml加载yaml
 */
class StarbugYamlApplicationTests {

    @Test
    public void test1() throws IOException {
        Yaml yaml = new Yaml();
        Map<String, Object> map = yaml.load(new ClassPathResource("snake1.yml").getInputStream());
        System.out.println(map);
    }

    @Test
    public void test2() throws IOException {
        Yaml yaml = new Yaml();
        Iterable<Object> objects = yaml.loadAll(new ClassPathResource("snake2.yml").getInputStream());
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    @Test
    public void test3() throws IOException {
        Yaml yaml = new Yaml();
        Person person = yaml.loadAs(new ClassPathResource("snake1.yml").getInputStream(), Person.class);
        System.out.println(person);
    }

}

