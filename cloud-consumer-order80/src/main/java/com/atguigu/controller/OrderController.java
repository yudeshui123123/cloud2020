package com.atguigu.controller;

import com.atguigu.cloudapicommons.entity.CommonResult;
import com.atguigu.cloudapicommons.entity.Payment;
import com.atguigu.lb.LoadBalanced;
import com.atguigu.service.feign.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    //public static final String PAYMENT_URL = "http://127.0.0.1:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalanced loadBalanced;

    @GetMapping("/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }
    @GetMapping("/getPayment/{id}")
    public CommonResult getPayment(@PathVariable("id")long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPayment/"+id,CommonResult.class);
    }
    @GetMapping("/getPayment/getForEntity/{id}")
    public CommonResult getPayment2(@PathVariable("id")long id){
        ResponseEntity<CommonResult> resultResponseEntity = restTemplate.getForEntity(PAYMENT_URL+"/payment/getPayment/"+id,CommonResult.class);
        if(resultResponseEntity.getStatusCode().is2xxSuccessful()){
            return resultResponseEntity.getBody();
        }else{
            return new CommonResult(500,"远程调用出现错误！");
        }
    }
    @GetMapping(value = "/payment/lb")
    public String lb(){
        List<ServiceInstance> list = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(list == null || list.size() <= 0){
            return null;
        }
        ServiceInstance instance = loadBalanced.instance(list);
        return restTemplate.getForObject(instance.getUri()+"/payment/lb",String.class);
    }

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return paymentService.getConfigInfo();
    }
}
