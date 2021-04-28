package com.guan.rule;

import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/18 10:20
 */
@Configuration
public class MySelfRule {
    @Bean
    public AbstractLoadBalancerRule getRule() {
        return new RandomRule();
    }
}
