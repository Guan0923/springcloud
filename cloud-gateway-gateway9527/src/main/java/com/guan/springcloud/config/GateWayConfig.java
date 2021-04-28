package com.guan.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/26 21:17
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder route) {
        RouteLocatorBuilder.Builder routes = route.routes();
        routes.route("cloud-payment", r -> r.path("/guonei/**").uri("http://news.baidu.com"));
        return routes.build();
    }
}
