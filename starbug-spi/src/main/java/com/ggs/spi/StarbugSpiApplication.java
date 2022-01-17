package com.ggs.spi;

import com.ggs.spi.service.ICustomSvc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;
import java.util.ServiceLoader;

/**
 * ICustomSvc：服务提供接口（也就是 SPI）
 * CustomSvcOne/CustomSvcTwo：实现者（这里直接在一个项目中简单实现，也可以通过 jar 包导入的方式实现）
 * cbuc.life.spi.service.ICustomSvc：配置文件
 */
public class StarbugSpiApplication {

    public static void main(String[] args) {
        //JDK原生SPI案例
        ServiceLoader<ICustomSvc> svcs = ServiceLoader.load(ICustomSvc.class);
        svcs.forEach(s -> System.out.println(s.getName()));

        System.out.println("------------------------------------------------------------");
        //Spring使用的SPI,模仿jar包中spring.factories中的格式编写即可
        List<ICustomSvc> svcList = SpringFactoriesLoader.loadFactories(ICustomSvc.class, Thread.currentThread().getContextClassLoader());
        svcList.forEach(s -> System.out.println(s.getName()));
    }

}
