package com.noob.sportsdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
public class Event {
    @TableId(type = IdType.AUTO)
    private Integer eventId;
    private String  eventName;
    private String eventDate;
    private String  eventTime;
    private String eventZone;
    private String eventDis;
    private String eventPlayernumber;
    private String eventJoinednumber;
    private String eventHolder;

}
