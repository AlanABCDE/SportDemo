package com.noob.sportsdemo.controller;

import com.google.gson.Gson;
import com.noob.sportsdemo.common.Result;
import com.noob.sportsdemo.entity.Matchresult;
import com.noob.sportsdemo.entity.Playersheet;
import com.noob.sportsdemo.entity.User;
import com.noob.sportsdemo.mapper.TeamMapper;
import com.noob.sportsdemo.service.IPlayersheetService;
import com.noob.sportsdemo.service.impl.PlayersheetServiceImpl;
import com.noob.sportsdemo.service.impl.TeamServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sign")
@CrossOrigin
public class PlayersheetController {

    @Resource
    public IPlayersheetService playersheetService;
    public Gson gson = new Gson();

    @PostMapping("/sign")
    public Result sign(@RequestBody Playersheet playersheet){
        playersheetService.saveOrUpdate(playersheet);
        return Result.success();
    }
    @GetMapping ("/selUser/{username}")
    public Result selUser(@PathVariable String username) {
        return Result.success(playersheetService.selectByUsername(username));
    }
    @GetMapping("/getUser")
    public String getUser() {
        List<Playersheet> playersheets = playersheetService.list();
        System.out.println(playersheets);
        return gson.toJson(playersheets);
    }
}
