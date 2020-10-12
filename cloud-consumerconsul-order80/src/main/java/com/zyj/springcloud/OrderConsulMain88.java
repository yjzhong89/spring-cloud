package com.zyj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yjzhong
 * @date 2020/10/2 12:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain88 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain88.class);
    }
}
