package com.noob.sportsdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noob.sportsdemo.entity.Team;
import com.noob.sportsdemo.mapper.TeamMapper;
import com.noob.sportsdemo.service.ITeamService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements ITeamService {

    @Resource
    private TeamMapper teamMapper;
    @Override
    public List<Team> selectTeam(String teamName) {
        return teamMapper.selectByTeamName(teamName);
    }
}
