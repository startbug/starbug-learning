package com.ggs.spi;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @Author lianghaohui
 * @Date 2022/1/17 14:06
 * @Description Bootstrap ClassLoader：负责加载 JDK 自带的 rt.jar 包中的类文件，是所有类加载的父类
 * Extension ClassLoader：负责加载 java 的扩展类库从 jre/lib/ect或 java.ext.dirs 系统属性指定的目录下加载类
 * System ClassLoader：负责从 classpath 环境变量中加载类文件
 */
class StarbugSpiApplicationTests {

    public static void main(String[] args) throws IOException {
        String name = "java/sql/Array.class";
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(name);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url.toString());
        }
    }

}
