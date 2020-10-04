package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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
public class Application80 {

    public static void main(String[] args) {
        SpringApplication.run(Application80.class);
    }
}
