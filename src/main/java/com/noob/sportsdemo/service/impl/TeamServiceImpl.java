package com.noob.sportsdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noob.sportsdemo.entity.Event;
import com.noob.sportsdemo.entity.Team;
import com.noob.sportsdemo.mapper.EventMapper;
import com.noob.sportsdemo.mapper.TeamMapper;
import com.noob.sportsdemo.service.IEventService;
import com.noob.sportsdemo.service.ITeamService;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements ITeamService {
}
