package com.ggs.dynamic_proxy.service.impl;

import com.ggs.dynamic_proxy.service.HelloService;

/**
 * @Author lianghaohui
 * @Date 2022/1/19 13:42
 * @Description
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }

}
