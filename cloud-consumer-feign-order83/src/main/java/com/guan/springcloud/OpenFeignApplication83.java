package com.guan.springcloud;

import com.guan.springcloud.config.LoggingConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/18 11:42
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(defaultConfiguration = {LoggingConfig.class})
public class OpenFeignApplication83 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication83.class, args);
    }
}
