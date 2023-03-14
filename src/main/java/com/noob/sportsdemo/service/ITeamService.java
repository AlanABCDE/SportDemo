package com.noob.sportsdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.noob.sportsdemo.entity.Team;

import java.util.List;

public interface ITeamService extends IService<Team> {
    List<Team> selectTeam(String teamName);
}
