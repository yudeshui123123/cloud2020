package com.atguigu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/11/4 17:01
 * @description:
 */
@Component
@EnableBinding(Sink.class) //消费sink
public class MessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者1号  端口："+serverPort+"，收到的消息："+message.getPayload());
    }
}
