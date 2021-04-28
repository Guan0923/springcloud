package com.guan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/19 8:55
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderApplication84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication84.class, args);
    }
}
