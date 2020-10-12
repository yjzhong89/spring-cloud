package com.zyj.springcloud.controller;

import com.zyj.springcloud.entities.CommonResult;
import com.zyj.springcloud.entities.Payment;
import com.zyj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yjzhong
 * @date 2020/9/25 9:10
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int paymentResult = paymentService.create(payment);
        log.info("*** 插入成功：" + paymentResult);

        if (paymentResult > 0) {
            return new CommonResult(200, "插入数据成功！端口号为：" + serverPort, paymentResult);
        } else {
            return new CommonResult(414, "插入数据失败！端口号为：" + serverPort, null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment paymentResult = paymentService.getPaymentById(id);
        log.info("*** 获取数据成功：" + paymentResult);

        if (paymentResult != null) {
            return new CommonResult(200, "获取数据成功！端口号为：" + serverPort, paymentResult);
        } else {
            return new CommonResult(414, "没有对应查询结果，端口号为：" + serverPort + "，查询ID为：" + id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service：" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance: instances) {
            log.info(instance.getServiceId() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
