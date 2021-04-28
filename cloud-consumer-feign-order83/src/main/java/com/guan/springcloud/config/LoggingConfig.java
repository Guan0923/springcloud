package com.guan.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/18 12:34
 */
@Configuration
public class LoggingConfig {

@Bean
    Logger.Level getLevel() {
        return Logger.Level.FULL;
    }
}
