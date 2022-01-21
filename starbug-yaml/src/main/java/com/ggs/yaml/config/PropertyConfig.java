package com.ggs.yaml.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * @Author lianghaohui
 * @Date 2022/1/21 11:13
 * @Description
 */
@Configuration
public class PropertyConfig {


    /**
     * 将yaml加载到环境配置参数中
     * 配合AnotherYamlController试用
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yamlProFb = new YamlPropertiesFactoryBean();
        yamlProFb.setResources(new ClassPathResource("application2.yml"));
        configurer.setProperties(yamlProFb.getObject());
        return configurer;
    }

}
