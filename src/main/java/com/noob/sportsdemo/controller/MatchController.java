package com.noob.sportsdemo.controller;


import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.noob.sportsdemo.common.Constants;
import com.noob.sportsdemo.common.Result;
import com.noob.sportsdemo.entity.Event;
import com.noob.sportsdemo.entity.Matchresult;
import com.noob.sportsdemo.entity.Message;
import com.noob.sportsdemo.entity.dto.MatchresultDTO;
import com.noob.sportsdemo.entity.dto.UserDTO;
import com.noob.sportsdemo.mapper.MatchresultMapper;
import com.noob.sportsdemo.service.IMatchresultService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
@CrossOrigin
public class MatchController {
    @Resource
    public MatchresultMapper matchresultMapper;
    public Gson gson = new Gson();
    @Resource
    public IMatchresultService matchresultService;

    @GetMapping("/getMatch")
    public String getMatch() {
        List<Matchresult> matchresults = matchresultService.list();
        System.out.println(matchresults);
        return gson.toJson(matchresults);
    }
    @PostMapping("/addMatch")
    public Result addMatch(@RequestBody Matchresult matchresult){
        matchresultService.saveOrUpdate(matchresult);
        return Result.success();
    }
    @PostMapping("/updateResult")
    public Result updateResult(@RequestBody MatchresultDTO matchresultDTO){
        matchresultDTO.setMatchStatus(matchresultDTO.getMatchStatus());
        matchresultDTO.setMatchScore(matchresultDTO.getMatchScore());
        matchresultDTO.setMatchPlayer(matchresultDTO.getMatchPlayer());
        matchresultDTO.setMatchRank(matchresultDTO.getMatchRank());
        matchresultService.updateResultByStatus(matchresultDTO);
        return Result.success();
    }
}
