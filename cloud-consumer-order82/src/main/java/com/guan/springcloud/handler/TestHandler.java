package com.guan.springcloud.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/17 16:41
 */
@RestController
public class TestHandler {

    private final String INVOKE_URL = "http://cloud-payment";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/consul")
    public String method() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}



