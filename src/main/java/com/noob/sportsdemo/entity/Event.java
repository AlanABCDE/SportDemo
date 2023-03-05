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
    private Integer id;
    private String  eventName;
    private Date eventDate;
    private Time eventTime;
    private String eventTplace;
    private String eventDis;
    private String eventPlayernumber;

}
