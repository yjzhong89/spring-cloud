package com.zyj.springcloud.loadBalancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yjzhong
 * @date 2020/10/3 12:14
 */
@Component
public class MyLoadBalancer implements ILoadBalancer {

    private AtomicInteger integer = new AtomicInteger(0);
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = integer.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
        } while (!integer.compareAndSet(current, next));
        return next;
    }
}
