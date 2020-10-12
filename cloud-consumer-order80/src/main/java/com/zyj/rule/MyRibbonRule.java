package com.zyj.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yjzhong
 * @date 2020/10/3 11:27
 */
@Configuration
public class MyRibbonRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
