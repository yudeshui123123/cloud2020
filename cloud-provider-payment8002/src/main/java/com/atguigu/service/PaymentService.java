package com.atguigu.service;


import com.atguigu.cloudapicommons.entity.Payment;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/2 18:35
 * @description:
 */

public interface PaymentService {
    Integer createByPayment(Payment payment);

    Payment getPaymentById(Long id);
}
