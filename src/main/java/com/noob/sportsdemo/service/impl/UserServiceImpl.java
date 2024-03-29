package com.noob.sportsdemo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noob.sportsdemo.common.Constants;
import com.noob.sportsdemo.entity.User;
import com.noob.sportsdemo.entity.dto.UserDTO;
import com.noob.sportsdemo.entity.dto.UserPasswordDTO;
import com.noob.sportsdemo.exception.ServiceException;
import com.noob.sportsdemo.mapper.UserMapper;
import com.noob.sportsdemo.service.IUserService;
import com.noob.sportsdemo.utils.TokenUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDTO login(UserDTO userDTO) {//登录
        User one = getUserInfo(userDTO);
        if (one != null) {
            BeanUtil.copyProperties(one, userDTO, true);//从数据库中的信息向userDTO中复制
//            设置token
            String token = TokenUtils.genToken(one.getUid().toString(), one.getPassword());
            userDTO.setToken(token);

            String role = one.getRole();//查询当前角色
//            List<Menu> roleMenus = getRoleMenus(role);//设置当前角色菜单列表
//            userDTO.setMenus(roleMenus);
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    @Override
    public User register(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if (one == null) {
            one = new User();
            BeanUtil.copyProperties(userDTO, one, true);//从数据库中的信息向userDTO向用户复制
            save(one);//存储到数据库
        } else {
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }
        return one;
    }

    @Override
    public void updatePassword(UserPasswordDTO userPasswordDTO) {
        int update = userMapper.updatePassword(userPasswordDTO);
        if (update < 1) {
            throw new ServiceException(Constants.CODE_600, "密码错误");
        }
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    private User getUserInfo(UserDTO userDTO) {//获取当前角色的菜单列表
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        queryWrapper.eq("password", userDTO.getPassword());
        User one;
        // 处理异常情况
        try {
            one = getOne(queryWrapper);//数据库查询

        } catch (Exception e) {//捕获异常ServiceException
//            Log.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }

 /*   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }*/


}