package com.noob.sportsdemo.controller;

import com.google.gson.Gson;
import com.noob.sportsdemo.common.Result;
import com.noob.sportsdemo.entity.Event;
import com.noob.sportsdemo.entity.Message;
import com.noob.sportsdemo.entity.User;
import com.noob.sportsdemo.service.IMessageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/addMsg")
    public Result addMsg(@RequestBody Message message){
        messageService.saveOrUpdate(message);
        return Result.success();
    }
    @PostMapping("/updateMsg")
    public Result updateMsg(@RequestBody Message message){
        messageService.saveOrUpdate(message);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return Result.success(messageService.removeById(id)) ;
    }
}
