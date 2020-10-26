package com.atguigu.controller;

import com.atguigu.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/15 10:31
 * @description:
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/ok/{id}")
    public String getPayment(@PathVariable("id")Integer id){
        log.info("正常访问");
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/timeOut")
    public String getTimeOut(){
        log.info("延迟访问");
        return paymentService.paymentInfo_TimeOut();
    }

    //*******服务熔断


    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        log.info("访问服务熔断的方法");
        return paymentService.paymentCircuitBreaker(id);
    }
}
