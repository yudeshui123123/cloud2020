package com.atguigu.service.impl;

import com.atguigu.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/28 16:55
 * @description:
 */
@EnableBinding(Source.class) //定义消息的推送管道
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*******serial:"+serial);
        return null;
    }
}
