package com.noob.sportsdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Team {
    @TableId(type = IdType.AUTO)
    private Integer teamId;
    private String teamName;
    private String username;
    private String classNo;

}
