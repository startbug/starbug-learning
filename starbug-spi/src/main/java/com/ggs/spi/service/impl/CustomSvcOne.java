package com.ggs.spi.service.impl;

import com.ggs.spi.service.ICustomSvc;

/**
 * @Author lianghaohui
 * @Date 2022/1/17 14:13
 * @Description
 */
public class CustomSvcOne implements ICustomSvc {

    @Override
    public String getName() {
        return "CustomSvc - One";
    }

}
