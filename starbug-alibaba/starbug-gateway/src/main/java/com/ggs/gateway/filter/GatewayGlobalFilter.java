package com.ggs.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author lianghaohui
 * @Date 2022/1/25 16:24
 * @Description
 */
@Slf4j
@Configuration
public class GatewayGlobalFilter implements GlobalFilter, Ordered {

    @Value("${test.name}")
    private String name;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("name:{}", name);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

}
