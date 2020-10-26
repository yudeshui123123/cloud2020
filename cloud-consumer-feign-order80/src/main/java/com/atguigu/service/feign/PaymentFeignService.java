package com.atguigu.service.feign;

import com.atguigu.cloudapicommons.entity.CommonResult;
import com.atguigu.cloudapicommons.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/13 17:38
 * @description:
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @PostMapping(value = "/payment/create")
    CommonResult createPayment(@RequestBody Payment payment);

    @GetMapping("/payment/getPayment/{id}")
    CommonResult getPayment(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/lb")
    String getPaymentLB();

    @GetMapping("/payment/timeOut")
    public String timeOut();
}
