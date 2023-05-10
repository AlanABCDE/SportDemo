package com.noob.sportsdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.noob.sportsdemo.entity.Playersheet;
import com.noob.sportsdemo.entity.Team;
import com.noob.sportsdemo.entity.User;

import java.util.List;

public interface IPlayersheetService extends IService<Playersheet> {
    List<Playersheet> selectByUsername(String username);
}
