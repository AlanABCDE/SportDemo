package com.noob.sportsdemo.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class Event {
    @TableId(type = IdType.AUTO)
    private Integer eventId;
    private String  eventName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date eventDate;
    @JsonFormat(pattern="HH:mm:ss")
    private Time  eventTime;
    private String  eventZone;
    private String  eventDis;
    private String  eventPlayernumber;
    private String  eventJoinednumber;
    private String  eventHolder;

}
