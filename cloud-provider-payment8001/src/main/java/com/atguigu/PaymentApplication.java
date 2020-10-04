package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/2 16:32
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.atguigu.mapper"})
public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.atguigu.PaymentApplication.class);
    }
}
