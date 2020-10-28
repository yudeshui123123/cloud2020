package com.atguigu.controller;

import com.atguigu.cloudapicommons.entity.CommonResult;
import com.atguigu.cloudapicommons.entity.Payment;
import com.atguigu.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RefreshScope
@Slf4j
public class PaymentController {

    @Value("${config.info}")
    private String configInfo;

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        Integer byPayment = paymentService.createByPayment(payment);
        if(byPayment > 0){
            log.info("插入:"+payment);
            return new CommonResult(200,"新增成功,端口号为："+serverPort,byPayment);
        }
        return new CommonResult(400,"新增失败",null);
    }

    @GetMapping("/getPayment/{id}")
    private CommonResult getPayment(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if(paymentById == null){
            return new CommonResult(400,"查询失败",null);
        }
        return new CommonResult(200,"查询成功，端口号为："+serverPort,paymentById);
    }

    @GetMapping("/discovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(service ->{
            System.out.println("service:  "+service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> {
            System.out.println(instance.getInstanceId()+","+instance.getServiceId()+","+instance.getHost()
                    +","+instance.getPort()+","+instance.getUri());
        });
        return discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/timeOut")
    public String timeOut(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "服务返回用时3s";
    }

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo+"    :  "+serverPort;
    }
}
