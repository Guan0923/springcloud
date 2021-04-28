package com.guan.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/19 10:57
 */
@Component
public class ErrorServiceImpl implements OrderService {
    @Override
    public String payment_OK() {
        return "ErrorServiceImpl---ok!!";
    }

    @Override
    public String payment_TimeOut() {
        return "ErrorServiceImpl---timeout!!";
    }
}
