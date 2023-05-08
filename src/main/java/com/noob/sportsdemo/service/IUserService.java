package com.noob.sportsdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.noob.sportsdemo.entity.Event;
import com.noob.sportsdemo.entity.User;
import com.noob.sportsdemo.entity.dto.UserDTO;
import com.noob.sportsdemo.entity.dto.UserPasswordDTO;

import java.util.List;

public interface IUserService extends IService<User> {
    UserDTO login(UserDTO userDTO) ;

    User register(UserDTO userDTO);

    void updatePassword(UserPasswordDTO userPasswordDTO);
    User selectByUsername(String username);

}
