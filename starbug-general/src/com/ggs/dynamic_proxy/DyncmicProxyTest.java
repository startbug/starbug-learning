package com.ggs.dynamic_proxy;

import com.ggs.dynamic_proxy.proxy.HelloServiceProxy;
import com.ggs.dynamic_proxy.service.HelloService;
import com.ggs.dynamic_proxy.service.impl.HelloServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @Author lianghaohui
 * @Date 2022/1/19 13:44
 * @Description 动态单例案例
 */
public class DyncmicProxyTest {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloServiceProxy handler = new HelloServiceProxy(helloService);
        ClassLoader classLoader = helloService.getClass().getClassLoader();
        Class<?>[] interfaces = helloService.getClass().getInterfaces();
        HelloService o = (HelloService) Proxy.newProxyInstance(classLoader, interfaces, handler);
        o.sayHello("xxxx");
    }

}
