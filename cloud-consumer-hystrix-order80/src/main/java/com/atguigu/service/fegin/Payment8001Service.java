package com.atguigu.service.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/15 15:53
 * @description:
 */
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT8001",fallback = PaymentFallBack8001.class)
public interface Payment8001Service {

    @GetMapping("/payment/ok/{id}")
    String getPayment(@PathVariable("id")Integer id);

    @GetMapping("/payment/timeOut")
    String getTimeOut();
}
