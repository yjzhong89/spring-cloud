package com.zyj.springcloud.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author yjzhong
 * @date 2020/10/14 16:34
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageController {
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者1号，接收到的消息是：" + message.getPayload());
    }
}
