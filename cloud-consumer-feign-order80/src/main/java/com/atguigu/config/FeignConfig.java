package com.atguigu.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/14 16:34
 * @description:
 * 配置日志级别
 */
@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}
