package com.guan.springcloud.handler;

import com.guan.springcloud.pojo.CommonResult;
import com.guan.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/16 11:36
 */
@RestController
@Slf4j
public class Order80Handler {

    private final String PAYMENT_URL = "http://CLOUD-PAYMENT/cloud-payment";
    //    private final String PAYMENT_URL = "http://localhost:8001/cloud-payment";
    private final String PAYMENT_HYSTRIX_URL = "http://CLOUD-HYSTRIX-PAYMENT";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/query/payment/{id}.html")
    public CommonResult<Payment> queryPaymentById(@PathVariable Integer id) {
        return restTemplate.getForObject(PAYMENT_URL + "/query/payment/" + id + ".html", CommonResult.class);
    }

    @PostMapping("/consumer/save/payment.html")
    public CommonResult<Object> savePaymentInfo(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/save/payment.html", payment, CommonResult.class);
    }

    @GetMapping("/consumer/query/payment/entity/{id}.html")
    public CommonResult<Payment> queryPaymentById2(@PathVariable Integer id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/query/payment/" + id + ".html", CommonResult.class);
        log.info(forEntity.toString());
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        }
        return new CommonResult<Payment>(444, "操作失败");
    }

    @PostMapping("/consumer/save/payment/entity.html")
    public CommonResult<Object> savePaymentInfo2(@RequestBody Payment payment) {
        ResponseEntity<CommonResult> responseEntity = restTemplate.postForEntity(PAYMENT_URL + "/save/payment.html", payment, CommonResult.class);
        log.info(responseEntity.toString());
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }
        return new CommonResult<>(444, "操作失败");
    }



}
