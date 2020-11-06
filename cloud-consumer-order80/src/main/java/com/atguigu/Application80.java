package com.atguigu;

import com.myrole.MySelfRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/3 15:16
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRole.class)
public class Application80 {

    public static void main(String[] args) {
        SpringApplication.run(Application80.class);
    }
}
