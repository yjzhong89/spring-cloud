package com.zyj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yjzhong
 * @date 2020/10/2 11:43
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain88 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain88.class);
    }
}
