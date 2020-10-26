package com.atguigu.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/15 10:07
 * @description:
 */
@Service
@DefaultProperties(defaultFallback = "globalHandler")
public class PaymentService {

    /**
     * 正常访问的方法
     * @param id
     * @return
     */
    @HystrixCommand
    public String paymentInfo_OK(Integer id){
        //int i = 5/0;
        return "线程池："+Thread.currentThread().getName()+" paymentInfoOk id:"+id+"\t 哈哈啊";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String paymentInfo_TimeOut(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "睡眠3秒！";
    }

    /**
     * 上面方法调用不符合约定时调用我
     * @return
     */
    public String paymentInfo_TimeOutHandler(){
        return "您调用的服务不行了，然后我上了";
    }

    /**
     * 全局服务降级方法
     * @return
     */
    public String globalHandler(){
        return "你调用的服务出错了，然后我出来顶着！--服务降级";
    }


    //=========================服务熔断
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreaker_fallBack",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value="10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value="60"),
            }
    )
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("*****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"调用流水号成功："+serialNumber;
    }

    public String paymentCircuitBreaker_fallBack(Integer id){
        return "id不能为负数："+id;
    }
}
