package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CloudConsumerOrder81Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder81Application.class, args);
    }

}
