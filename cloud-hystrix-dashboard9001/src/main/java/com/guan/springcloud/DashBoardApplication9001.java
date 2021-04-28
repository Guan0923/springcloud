package com.guan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/19 14:01
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashBoardApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashBoardApplication9001.class, args);
    }
}
