package com.noob.sportsdemo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noob.sportsdemo.common.Constants;
import com.noob.sportsdemo.entity.Matchresult;
import com.noob.sportsdemo.entity.User;
import com.noob.sportsdemo.entity.dto.MatchresultDTO;
import com.noob.sportsdemo.entity.dto.UserPasswordDTO;
import com.noob.sportsdemo.exception.ServiceException;
import com.noob.sportsdemo.mapper.MatchresultMapper;
import com.noob.sportsdemo.service.IMatchresultService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MatchresultServiceImpl extends ServiceImpl<MatchresultMapper, Matchresult> implements IMatchresultService {
    @Resource
    private MatchresultMapper matchresultMapper;




    private Matchresult getMatchInfo(MatchresultDTO matchresultDTO){
        QueryWrapper<Matchresult> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("match_status",matchresultDTO.getMatchStatus());
        queryWrapper.eq("match_score",matchresultDTO.getMatchScore());
        queryWrapper.eq("match_player",matchresultDTO.getMatchPlayer());
        queryWrapper.eq("match_rank",matchresultDTO.getMatchRank());
        Matchresult one ;
        try {
            one = getOne(queryWrapper);//数据库查询

        } catch (Exception e) {//捕获异常ServiceException
//
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }

    @Override
    public void updateResultByStatus(MatchresultDTO matchresultDTO) {
        int update= matchresultMapper.updateResultByStatus(matchresultDTO);
        if (update < 1) {
            throw new ServiceException(Constants.CODE_600, "密码错误");
        }
    }
}
