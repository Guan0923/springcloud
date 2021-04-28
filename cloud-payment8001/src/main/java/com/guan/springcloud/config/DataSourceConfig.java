package com.guan.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/16 10:46
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(value = "spring.datasource")
    public DataSource getDataSource() {
        return new DruidDataSource();
    }
}
