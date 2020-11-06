package com.atguigu.controller;

import com.atguigu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/11/4 16:25
 * @description:
 */
@RestController
@RequestMapping("/payment")
public class SendMessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/sendMessage")
    public String send(){
        return messageService.send();
    }
}
