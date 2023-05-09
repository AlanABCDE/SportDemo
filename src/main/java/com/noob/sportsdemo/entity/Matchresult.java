package com.noob.sportsdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter

public class Matchresult {
    @TableId(type = IdType.AUTO)
    private Integer matchId;
    private Integer eventId;
    private String eventName;
    private String matchStatus;
    private String eventZone;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date eventDate;
    @JsonFormat(pattern="HH:mm:ss")
    private Time eventTime;
    private String matchScore;
    private String matchPlayer;
    private String matchRank;

}
