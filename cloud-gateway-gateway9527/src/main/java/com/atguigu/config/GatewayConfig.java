package com.atguigu.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/23 15:45
 * @description:
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("path_route_guigu2",r -> r.path("/guonei2").uri("https://spring.io/projects/spring-cloud-gateway"))
                .route("path_route_guigu",r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
                .build();
    }

}
