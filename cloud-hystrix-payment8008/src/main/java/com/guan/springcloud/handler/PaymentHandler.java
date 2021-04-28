package com.guan.springcloud.handler;

import com.guan.springcloud.service.PaymentServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/19 8:17
 */
@RestController
@Slf4j
public class PaymentHandler {

    @Autowired
    private PaymentServiceImpl paymentService;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/hystrix/ok.html")
    public String payment_OK() {
        log.info("ok" + " " + port);
        return paymentService.payment_OK() + " 端口：" + port;
    }

    @RequestMapping("/payment/hystrix/timeout.html")
    public String payment_TimeOut() {
        log.info("timeout" + " " + port);
        return paymentService.payment_TimeOut() + " 端口：" + port;
    }

    @RequestMapping("/payment/hystrix/{id}.html")
    @HystrixCommand(fallbackMethod = "test_Fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String test(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("错啦");
        }
        return port + id;
    }

    public String test_Fallback(@PathVariable("id") Integer id) {
        return "请输入正确的数字";
    }
}
