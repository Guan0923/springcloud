package com.guan.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/19 8:55
 */
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT", fallback = ErrorServiceImpl.class)
public interface OrderService {
    @RequestMapping("/payment/hystrix/ok.html")
    String payment_OK();

    @RequestMapping("/payment/hystrix/timeout.html")
    String payment_TimeOut();
}
