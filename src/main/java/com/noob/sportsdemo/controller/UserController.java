package com.noob.sportsdemo.controller;

import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;

import com.noob.sportsdemo.common.Constants;
import com.noob.sportsdemo.common.Result;
import com.noob.sportsdemo.entity.User;
import com.noob.sportsdemo.entity.dto.UserDTO;
import com.noob.sportsdemo.entity.dto.UserPasswordDTO;
import com.noob.sportsdemo.mapper.UserMapper;
import com.noob.sportsdemo.service.IUserService;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    public UserMapper userMapper;
    @Resource
    private IUserService userService;

    public Gson gson = new Gson();

    @GetMapping("/getUser")
    public String getUser() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        return gson.toJson(users);
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            return Result.error(Constants.CODE_400,"参数错误");
        }
        UserDTO dto = userService.login(userDTO);//包装dto
        return Result.success(dto);
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO){
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            return Result.error(Constants.CODE_400,"参数错误");
        }
        return Result.success(userService.register(userDTO));
    }

    /**
     * 修改密码
     * @param userPasswordDTO
     * @return
     */
    @PostMapping("/password")
    public Result password(@RequestBody UserPasswordDTO userPasswordDTO) {
        userPasswordDTO.setPassword(userPasswordDTO.getPassword());
        userPasswordDTO.setNewPassword(userPasswordDTO.getNewPassword());
        userService.updatePassword(userPasswordDTO);
        return Result.success();
    }
}