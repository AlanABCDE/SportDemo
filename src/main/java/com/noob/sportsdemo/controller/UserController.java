package com.noob.sportsdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.noob.sportsdemo.entity.User;
import com.noob.sportsdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    public UserMapper userMapper;
    public Gson gson=new Gson();

    @GetMapping("/getUser")
    public String getUser(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        return gson.toJson(users);
    }
    @PostMapping("/login")
    public String Login(@RequestBody User user){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.setEntity(user);
        User user_selected = userMapper.selectOne(userQueryWrapper);
        if(user_selected==null){
            return "no such user";
        }
        return "success";
    }
    @PostMapping("/register")
    public void register(@RequestBody User user){
        userMapper.insert(user);
    }

}
