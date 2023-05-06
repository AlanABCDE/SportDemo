package com.noob.sportsdemo.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
@Setter
@Getter
public class Message {
    @TableId(type = IdType.AUTO)
    private Integer msgId;
    private String title;
    private String content;
    private Timestamp createTime;



}
