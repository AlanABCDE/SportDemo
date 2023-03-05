package com.noob.sportsdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    @TableId(type = IdType.AUTO)
    private Integer uid;
    private String username;
    private String sex;
    private String password;
    private String role;
    private String email;
    private String avatarUrl;


}
