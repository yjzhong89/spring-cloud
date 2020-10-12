package com.zyj.springcloud.controller;

import com.zyj.springcloud.entities.CommonResult;
import com.zyj.springcloud.entities.Payment;
import com.zyj.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yjzhong
 * @date 2020/10/12 11:24
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon，客户端默认等待时间1s
        return paymentFeignService.paymentFeignTimeout();
    }
}
