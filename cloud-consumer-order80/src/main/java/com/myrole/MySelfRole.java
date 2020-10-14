package com.myrole;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/13 10:49
 * @description:
 */
@Configuration
public class MySelfRole {
    @Bean
    public IRule rule(){
        return new RandomRule();
    }
}
