package com.guan.springcloud.service;

import com.guan.springcloud.dao.PaymentMapper;
import com.guan.springcloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/16 10:23
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper mapper;

    @Override
    public Integer savePaymentInfo(Payment payment) {
        if (payment == null) {
            return 0;
        }
        return mapper.insert(payment);
    }

    @Override
    public Payment queryPaymentInfo(Integer id) {
        if (id == null || id <= 0) {
            return null;
        }
        return mapper.selectById(id);
    }
}
