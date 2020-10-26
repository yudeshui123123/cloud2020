package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * EnableEurekaClient加不加都行，他都能识别
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CloudConsumerHystrixOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerHystrixOrder80Application.class, args);
    }

}
