package com.ggs.mock.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lianghaohui
 * @Date 2022/1/17 15:07
 * @Description
 * @ConditionalOnWebApplication: web应用才生效
 * @EnableConfigurationProperties(value = {StarbugProperties.class}): 将属性配置文件注入到IOC中
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(value = {StarbugProperties.class})
public class StarbugServiceAutoConfiguration {

    @Autowired
    private StarbugProperties starbugProperties;

    @Bean
    public StarbugService starbugService() {
        StarbugService starbugService = new StarbugService();
        starbugService.setStarbugProperties(starbugProperties);
        return starbugService;
    }

}
