package com.noob.sportsdemo.controller;

import com.google.gson.Gson;
import com.noob.sportsdemo.common.Result;
import com.noob.sportsdemo.entity.Event;
import com.noob.sportsdemo.entity.Team;
import com.noob.sportsdemo.mapper.EventMapper;
import com.noob.sportsdemo.mapper.TeamMapper;
import com.noob.sportsdemo.service.impl.EventServiceImpl;
import com.noob.sportsdemo.service.impl.TeamServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/team")
@CrossOrigin
public class TeamController {

    @Resource
    private TeamServiceImpl teamService;

    @Resource
    public TeamMapper teamMapper;

    public Gson gson = new Gson();

    @GetMapping("/getTeam")
    public String getTeam() {
        List<Team> teams = teamMapper.getTeam();
        System.out.println(teams);
        return gson.toJson(teams);
    }
}
