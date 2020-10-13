package com.zyj.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author yjzhong
 * @date 2020/10/13 9:27
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK() {
        return "PaymentFallbackService --- paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout() {
        return "PaymentFallbackService --- paymentInfo_Timeout";
    }
}
