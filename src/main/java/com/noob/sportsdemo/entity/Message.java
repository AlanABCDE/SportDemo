package com.noob.sportsdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class Message {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private Date date;
    private  String uploader;

}
