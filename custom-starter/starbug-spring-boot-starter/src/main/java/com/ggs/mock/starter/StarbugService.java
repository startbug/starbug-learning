package com.ggs.mock.starter;

/**
 * @Author lianghaohui
 * @Date 2022/1/17 15:06
 * @Description
 */
public class StarbugService {

    private StarbugProperties starbugProperties;

    public String sayHello(String name) {
        return "Hello " + name + "," + starbugProperties.getSuffix();
    }

    public StarbugProperties getStarbugProperties() {
        return starbugProperties;
    }

    public void setStarbugProperties(StarbugProperties starbugProperties) {
        this.starbugProperties = starbugProperties;
    }

}
