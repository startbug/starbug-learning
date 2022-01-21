package com.ggs.yaml.controller;

import com.ggs.yaml.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lianghaohui
 * @Date 2022/1/21 10:29
 * @Description
 */
@RestController
@RequestMapping("/env")
public class EnvironmentYamlController {

    /**
     * 获取当前正在运行的环境
     */
    @Autowired
    private Environment environment;

    @GetMapping("/property")
    public R test() {
        //获取环境中的变量
        System.out.println(environment.getProperty("my.name"));
        Integer age = environment.getProperty("my.age", Integer.class);
        System.out.println(age);
        String notExist = environment.getProperty("my.notexist", String.class, "默认值");
        System.out.println(notExist);
        String favorites0 = environment.getProperty("my.favorites[0]");
        String favorites1 = environment.getProperty("my.favorites[1]");
        String favorites2 = environment.getProperty("my.favorites[2]");
        System.out.println(favorites0);
        System.out.println(favorites1);
        System.out.println(favorites2);
        return R.ok();
    }

    /**
     * 判断激活的配置文件
     */
    @GetMapping("activeEnv")
    private R getActiveEnv(String profile) {
        System.out.println(environment.acceptsProfiles("pro"));
        System.out.println(environment.acceptsProfiles("dev"));

        String[] activeProfiles = environment.getActiveProfiles();
        for (String activeProfile : activeProfiles) {
            System.out.println(activeProfile);
        }
        return R.ok().data(environment.acceptsProfiles(Profiles.of(profile)));
    }

}
