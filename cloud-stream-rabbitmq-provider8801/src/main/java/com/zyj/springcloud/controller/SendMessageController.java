package com.zyj.springcloud.controller;

import com.zyj.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yjzhong
 * @date 2020/10/14 16:17
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider provider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return provider.send();
    }
}
