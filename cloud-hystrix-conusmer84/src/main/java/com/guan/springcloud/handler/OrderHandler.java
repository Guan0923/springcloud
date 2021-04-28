package com.guan.springcloud.handler;

import com.guan.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/19 8:55
 */
@RestController
@DefaultProperties(defaultFallback = "payment_TimeOut_Fallback", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
})
public class OrderHandler {
    @Qualifier("com.guan.springcloud.service.OrderService")
    @Autowired
    private OrderService orderService;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/hystrix/ok.html")
//    @HystrixCommand
    public String payment_OK() {
//        int age = 10 / 0;
        return orderService.payment_OK();
    }

    //    @HystrixCommand(fallbackMethod = "payment_TimeOut_Fallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @RequestMapping("/payment/hystrix/timeout.html")
    @HystrixCommand
    public String payment_TimeOut() {
        return orderService.payment_TimeOut();
    }

    public String payment_TimeOut_Fallback() {
        return "出错啦~~~" + port;
    }
}
