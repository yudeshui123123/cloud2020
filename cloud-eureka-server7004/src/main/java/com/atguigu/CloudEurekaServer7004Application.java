package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServer7004Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer7004Application.class, args);
    }

}
