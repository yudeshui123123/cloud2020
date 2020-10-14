package com.atguigu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/12 9:55
 * @description:
 */
@RestController
@Slf4j
public class MyController {

    public static final String URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String test01(){
        return restTemplate.getForObject(URL+"/payment/consul",String.class);
    }
}
