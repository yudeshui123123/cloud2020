package com.atguigu.controller;

import com.atguigu.cloudapicommons.entity.CommonResult;
import com.atguigu.cloudapicommons.entity.Payment;
import com.atguigu.service.feign.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/14 11:11
 * @description:
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class PaymentFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentFeignService.getPayment(id);
    }

    @PostMapping(value = "/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        return paymentFeignService.createPayment(payment);
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return paymentFeignService.getPaymentLB();
    }

    @GetMapping("/timeOut")
    public String timeOut(){
        //feign 客户端默认等待一秒钟，但是服务调用需要3秒中调用完
        return paymentFeignService.timeOut();
    }
}
