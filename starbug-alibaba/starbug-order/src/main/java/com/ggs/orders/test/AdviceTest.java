package com.ggs.orders.test;

import com.ggs.common.R;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author lianghaohui
 * @Date 2022/2/11 17:16
 * @Description Controller响应后，如果类型是R，则会进入beforeBodyWrite方法
 */
@ControllerAdvice
public class AdviceTest implements ResponseBodyAdvice<R> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public R beforeBodyWrite(R body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        body.setMessage("fuck off!!!");
        return body;
    }

}
