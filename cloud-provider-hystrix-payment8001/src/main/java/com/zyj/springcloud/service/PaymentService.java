package com.zyj.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yjzhong
 * @date 2020/10/12 14:53
 */
@Service
public class PaymentService {
    public String paymentInfo_OK() {
        return "线程池" + Thread.currentThread().getName() + " paymentInfo_OK";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_Handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Timeout() {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + " paymentInfo_Timeout";
    }

    public String paymentInfo_Timeout_Handler() {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_Timeout_Handler";
    }
}
