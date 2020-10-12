package com.zyj.springcloud.controller;

import com.zyj.springcloud.entities.CommonResult;
import com.zyj.springcloud.entities.Payment;
import com.zyj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
}
