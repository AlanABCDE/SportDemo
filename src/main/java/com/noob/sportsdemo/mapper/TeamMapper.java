package com.noob.sportsdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noob.sportsdemo.entity.Event;
import com.noob.sportsdemo.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeamMapper extends BaseMapper<Team> {

    @Select("select * from user join team on user.team_name = team.team_name where team.team_name = #{teamName};")
   List<Team> selectByTeamName(@Param("teamName")String teamName);
}
