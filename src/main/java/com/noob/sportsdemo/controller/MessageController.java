package com.noob.sportsdemo.controller;

import com.google.gson.Gson;
import com.noob.sportsdemo.common.Result;
import com.noob.sportsdemo.entity.Message;
import com.noob.sportsdemo.entity.User;
import com.noob.sportsdemo.service.IMessageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/msg")
@CrossOrigin
public class MessageController {

    @Resource
    private IMessageService messageService;
    public Gson gson = new Gson();

    @GetMapping("/getMsg")
    public String getMsg() {
        List<Message> messages = messageService.list();
        System.out.println(messages);
        return gson.toJson(messages);
    }
}
