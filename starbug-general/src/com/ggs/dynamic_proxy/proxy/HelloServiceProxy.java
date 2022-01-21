package com.ggs.dynamic_proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author lianghaohui
 * @Date 2022/1/19 13:43
 * @Description
 */
public class HelloServiceProxy implements InvocationHandler {

    private Object object;

    public HelloServiceProxy(Object object) {
        this.object = object;
    }

    /**
     * proxy: 当前对象(HelloServiceProxy)的代理对象,可以通过((Proxy) proxy).h==this得到true判断
     * method: 被代理对象的方法对象
     * args: 被代理对象的方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前");
        Object result = method.invoke(object, args);
        System.out.println("调用后");
        return result;
    }

}
