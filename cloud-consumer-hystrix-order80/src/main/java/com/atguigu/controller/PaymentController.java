package com.atguigu.controller;

import com.atguigu.service.fegin.Payment8001Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/15 15:58
 * @description:
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class PaymentController {

    @Autowired
    private Payment8001Service payment8001Service;

    @GetMapping("/ok/{id}")
    public String getOk(@PathVariable("id") Integer id){
        return payment8001Service.getPayment(id);
    }

    @GetMapping("/timeOut")
    public String getTimeOut(){
        return payment8001Service.getTimeOut();
    }
}
