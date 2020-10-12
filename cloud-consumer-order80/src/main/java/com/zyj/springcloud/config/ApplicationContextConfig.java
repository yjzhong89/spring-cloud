package com.zyj.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yjzhong
 * @date 2020/9/25 11:00
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
