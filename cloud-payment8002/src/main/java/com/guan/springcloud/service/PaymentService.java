package com.guan.springcloud.service;

import com.guan.springcloud.pojo.Payment;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/16 10:22
 */
public interface PaymentService {
    /**
     * savePaymentInfo
     * @param payment Payment
     * @return Integer
     */
    Integer savePaymentInfo(Payment payment);

    /**
     * queryPaymentInfo
     * @param id Integer
     * @return Payment
     */
    Payment queryPaymentInfo(Integer id);
}
