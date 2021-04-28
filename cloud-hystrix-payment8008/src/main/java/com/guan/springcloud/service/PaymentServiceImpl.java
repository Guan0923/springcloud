package com.guan.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/19 8:14
 */
@Service
public class PaymentServiceImpl {

    public String payment_OK() {
        return "正常运行";
    }

    @HystrixCommand(fallbackMethod = "payment_TimeOut_Fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String payment_TimeOut() {
        int timeOut = 5;
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int age = 10 / 0;
        return "超时时间 " + timeOut + " 秒";
    }

    public String payment_TimeOut_Fallback() {
        return "出错啦";
    }
}
