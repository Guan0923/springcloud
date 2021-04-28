package com.guan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/17 16:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Order82Application {
    public static void main(String[] args) {
        SpringApplication.run(Order82Application.class, args);
    }
}
