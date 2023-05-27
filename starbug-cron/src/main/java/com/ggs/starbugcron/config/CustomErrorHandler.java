package com.ggs.starbugcron.config;

import org.springframework.util.ErrorHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        log.error("定时任务报错了");
        t.printStackTrace();
    }

}
