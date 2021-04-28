package com.guan.springcloud.filter;

import com.netflix.discovery.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/27 9:01
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

    @Override
    @SuppressWarnings("*")
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //request和response等，都可以通过exchange获得
        //ServerHttpRequest request = exchange.getRequest();
        //请求域参数可以通过 exchange.getAttribute();
        //获取第一个参数····?name=123
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        log.info("***********************");
        //获取请求路径
        RequestPath path = exchange.getRequest().getPath();
        //pathWithinApplication就是请求的Controller路径
        //contextPath就是server.contextPath
        String value = path.pathWithinApplication().value();
        String[] split = value.split("/");


        if (StringUtils.isEmpty(name) && ! split[1].equals("discover")) {
            //不放行
            log.info("非法用户");
            ServerHttpResponse response = exchange.getResponse();
            //设置请求响应码
            response.setStatusCode(HttpStatus.SEE_OTHER);
            //设置跳转页面
            response.getHeaders().set(HttpHeaders.LOCATION, "/discover/client.html");
            //本次拦截结束
            return response.setComplete();
        }
        //放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //设置每个拦截器的顺序
        return 0;
    }
}
