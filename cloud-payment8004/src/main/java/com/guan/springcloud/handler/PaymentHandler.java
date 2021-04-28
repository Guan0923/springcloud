package com.guan.springcloud.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/16 10:26
 */
@RestController
public class PaymentHandler {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/zookeeper")
    public String method() {
        return "spring cloud  port:" + port + UUID.randomUUID().toString();
    }
}
