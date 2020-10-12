package com.zyj.springcloud.service;

import com.zyj.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
