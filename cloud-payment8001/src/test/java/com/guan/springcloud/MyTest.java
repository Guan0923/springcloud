package com.guan.springcloud;

import com.guan.springcloud.pojo.Payment;
import com.guan.springcloud.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/16 10:39
 */
@SpringBootTest
public class MyTest {
    @Autowired
    private PaymentService paymentService;

    @Test
    public void method() {
        Payment payment = paymentService.queryPaymentInfo(1);
        System.out.println(payment.toString());
    }
}
