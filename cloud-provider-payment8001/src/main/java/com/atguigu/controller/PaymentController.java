package com.atguigu.controller;

import com.atguigu.entity.CommonResult;
import com.atguigu.entity.Payment;
import com.atguigu.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/2 18:40
 * @description:
 */
@RequestMapping("/payment")
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public CommonResult createPayment(Payment payment){
        Integer byPayment = paymentService.createByPayment(payment);
        if(byPayment > 0){
            log.info("插入:"+payment);
            return new CommonResult(200,"新增成功",byPayment);
        }
        return new CommonResult(400,"新增失败",null);
    }

    @GetMapping("/getPayment/{id}")
    private CommonResult getPayment(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if(paymentById == null){
            return new CommonResult(400,"查询失败",null);
        }
        return new CommonResult(200,"查询成功",paymentById);
    }
}
