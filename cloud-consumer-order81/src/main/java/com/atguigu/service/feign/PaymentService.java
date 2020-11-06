package com.atguigu.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/11/5 17:50
 * @description:
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping("/payment/configInfo")
    String getConfigInfo();
}
