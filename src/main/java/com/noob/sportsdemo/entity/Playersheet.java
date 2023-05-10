package com.noob.sportsdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Playersheet {

    @TableId(type = IdType.AUTO)
    private Integer sheetId;
    private Integer eventId;
    private String eventName;
    private Integer uid;
    private String username;

}
