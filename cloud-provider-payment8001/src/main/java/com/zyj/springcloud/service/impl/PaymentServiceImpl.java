package com.zyj.springcloud.service.impl;

import com.zyj.springcloud.dao.PaymentDao;
import com.zyj.springcloud.entities.Payment;
import com.zyj.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yjzhong
 * @date 2020/9/25 9:06
 */
@Service
public class PaymentServiceImpl implements PaymentService  {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
