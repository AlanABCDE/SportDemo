package com.noob.sportsdemo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String password;
    private String avatarUrl;
    private String role;//角色
    private String token;
    private String sex;
    private String email;
    private String classNo;
    private String teamId;
    private String teamName;



}
