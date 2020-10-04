package com.atguigu.controller;

import com.atguigu.cloudapicommons.entity.CommonResult;
import com.atguigu.cloudapicommons.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/3 15:22
 * @description:
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    public static final String PAYMENT_URL = "http://127.0.0.1:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }
    @GetMapping("/getPayment/{id}")
    public CommonResult getPayment(@PathVariable("id")long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPayment/"+id,CommonResult.class);
    }
}
