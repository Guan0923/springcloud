package com.guan.springcloud.handler;

import com.guan.springcloud.pojo.CommonResult;
import com.guan.springcloud.pojo.Payment;
import com.guan.springcloud.service.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/18 11:46
 */
@RestController
public class TestHandler {

    @Autowired
    private OpenFeignService openFeignService;

    @GetMapping("/consumer/query/payment/{id}.html")
    public CommonResult<Payment> queryPaymentById(@PathVariable Integer id) {
        return openFeignService.queryPaymentById(id);
    }

    @RequestMapping("/consumer/payment/timeout.html")
    public String paymentFeignTimeout() {
        return openFeignService.paymentFeignTimeout();
    }
}
