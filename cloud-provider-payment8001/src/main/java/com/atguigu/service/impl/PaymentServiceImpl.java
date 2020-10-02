package com.atguigu.service.impl;

import com.atguigu.entity.Payment;
import com.atguigu.mapper.PaymentMapper;
import com.atguigu.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/2 18:37
 * @description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Integer createByPayment(Payment payment) {
        return paymentMapper.createByPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
