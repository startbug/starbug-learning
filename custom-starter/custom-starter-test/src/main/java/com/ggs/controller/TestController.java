package com.ggs.controller;

import com.ggs.mock.starter.StarbugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lianghaohui
 * @Date 2022/1/17 15:24
 * @Description 自定义starter --> starbug-spring-boot-starter
 * 如果自定义配置项在yml中没有提示信息，那么自定义的starter需要引入spring-boot-configuration-processor依赖
 * clear->install,可以看到META-INF目录下有一个spring-configuration-metadata.json文件
 * 这个就是代码提示需要的文件,刷新一下maven配置,在yml就会有提示了
 */
@RestController
public class TestController {

    @Autowired
    private StarbugService starbugService;

    @GetMapping("/test")
    public String testHello(String name) {
        return starbugService.sayHello(name);
    }

}
