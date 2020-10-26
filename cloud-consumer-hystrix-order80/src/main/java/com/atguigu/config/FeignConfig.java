package com.atguigu.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/15 15:52
 * @description:
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
