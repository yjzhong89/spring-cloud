package com.zyj.springcloud.loadBalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author yjzhong
 * @date 2020/10/3 12:13
 */
public interface ILoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
