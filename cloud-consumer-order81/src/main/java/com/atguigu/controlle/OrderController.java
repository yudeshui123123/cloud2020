package com.atguigu.controlle;

import com.atguigu.service.feign.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return paymentService.getConfigInfo();
    }
}
