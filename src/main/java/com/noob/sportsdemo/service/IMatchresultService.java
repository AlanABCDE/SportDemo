package com.noob.sportsdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.noob.sportsdemo.entity.Event;
import com.noob.sportsdemo.entity.Matchresult;
import com.noob.sportsdemo.entity.dto.MatchresultDTO;
import com.noob.sportsdemo.entity.dto.UserPasswordDTO;

import java.util.List;

public interface IMatchresultService extends IService<Matchresult> {

    void updateResultByStatus(MatchresultDTO matchresultDTO);
}
