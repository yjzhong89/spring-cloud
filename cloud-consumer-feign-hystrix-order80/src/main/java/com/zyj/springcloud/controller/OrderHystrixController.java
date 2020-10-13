package com.zyj.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zyj.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yjzhong
 * @date 2020/10/12 15:56
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok")
    public String paymentInfo_OK() {
        return paymentHystrixService.paymentInfo_OK();
    }

    @GetMapping("/consumer/payment/hystrix/timeout")
//    @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_Handler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout() {
        return paymentHystrixService.paymentInfo_Timeout();
    }

    public String paymentInfo_Timeout_Handler() {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_Timeout_Handler";
    }

    public String paymentInfo_Global_FallbackMethod() {
        return "全局异常处理信息";
    }
}
