package com.noob.sportsdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noob.sportsdemo.entity.Event;
import com.noob.sportsdemo.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeamMapper extends BaseMapper<Team> {

    @Select("select * from user join team on user.team_id = team.team_id where team.team_name = '三三说的都对';")
    public List<Team> getTeam();
}
