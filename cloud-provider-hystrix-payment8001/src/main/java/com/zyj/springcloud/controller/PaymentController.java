package com.zyj.springcloud.controller;

import com.zyj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yjzhong
 * @date 2020/10/12 14:56
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok")
    public String paymentInfo_OK() {
        String result = paymentService.paymentInfo_OK();
        log.info("*****" + result + "*****");
        return result;
    }

    @GetMapping("/payment/hystrix/timeout")
    public String paymentInfo_Timeout() {
        String result = paymentService.paymentInfo_Timeout();
        log.info("*****" + result + "*****");
        return result;
    }
}
