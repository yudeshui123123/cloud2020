package com.atguigu.service.feign;

import com.atguigu.cloudapicommons.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/13 17:38
 * @description:
 */
@FeignClient("CLOUD-PAYMENT")
public interface PaymentFeignService {
    Integer createByPayment(Payment payment);

    Payment getPaymentById(Long id);
}
