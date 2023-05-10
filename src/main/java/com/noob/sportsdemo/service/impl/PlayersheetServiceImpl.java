package com.noob.sportsdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noob.sportsdemo.entity.Playersheet;
import com.noob.sportsdemo.entity.Team;
import com.noob.sportsdemo.mapper.PlayersheetMapper;
import com.noob.sportsdemo.mapper.TeamMapper;
import com.noob.sportsdemo.service.IPlayersheetService;
import com.noob.sportsdemo.service.ITeamService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersheetServiceImpl extends ServiceImpl<PlayersheetMapper, Playersheet> implements IPlayersheetService {

}
