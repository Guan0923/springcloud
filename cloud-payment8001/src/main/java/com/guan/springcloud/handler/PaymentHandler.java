package com.guan.springcloud.handler;

import com.guan.springcloud.pojo.CommonResult;
import com.guan.springcloud.pojo.Payment;
import com.guan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/16 10:26
 */
@RestController
@Slf4j
public class PaymentHandler {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @PostMapping("/save/payment.html")
    public CommonResult<Integer> savePaymentInfo(@RequestBody Payment payment) {
        Integer res = paymentService.savePaymentInfo(payment);
        if (res <= 0) {
            return new CommonResult<>(444, "添加失败");
        }
        return new CommonResult<>(200, "添加成功,端口为:" + port, res);
    }

    @GetMapping("/query/payment/{id}.html")
    public CommonResult<Payment> queryPaymentInfo(@PathVariable("id") Integer id) {
        Payment payment = paymentService.queryPaymentInfo(id);
        if (payment == null) {
            return new CommonResult<>(444, "查询失败");
        }
        return new CommonResult<>(200, "查询成功,端口为:" + port, payment);
    }

    @GetMapping("/discover/client.html")
    @ResponseBody
    public Object getDiscoverClient() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT");
        services.forEach(e -> log.info("services = " + e));
        instances.forEach(e -> {
            log.info("port = " + e.getPort());
            log.info("host = " + e.getHost());
            log.info("instanceId = " + e.getInstanceId());
        });
        return this.discoveryClient;
    }

    @RequestMapping("/payment/timeout.html")
    public String paymentFeignTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return port;
    }
}
