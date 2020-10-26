package com.atguigu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/14 14:31
 * @description:
 */
@RestController
public class PaymentController {
    @GetMapping("test01")
    public String test01(){
        return "你好啊！";
    }
}
