package com.atguigu.mapper;

import com.atguigu.cloudapicommons.entity.Payment;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/2 18:22
 * @description:
 */
@Repository
public interface PaymentMapper {

    Integer createByPayment(Payment payment);

    Payment getPaymentById(Long id);
}
