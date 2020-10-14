package com.atguigu.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/13 14:59
 * @description:
 */
public interface LoadBalanced {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
