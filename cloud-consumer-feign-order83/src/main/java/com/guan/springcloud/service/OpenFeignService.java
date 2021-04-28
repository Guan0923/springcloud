package com.guan.springcloud.service;

import com.guan.springcloud.pojo.CommonResult;
import com.guan.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/18 11:44
 */
@FeignClient(value = "CLOUD-PAYMENT")
@RequestMapping("/cloud-payment")
public interface OpenFeignService {
    @GetMapping("/query/payment/{id}.html")
    CommonResult<Payment> queryPaymentById(@PathVariable("id") Integer id);

    @RequestMapping("/payment/timeout.html")
    String paymentFeignTimeout();
}
