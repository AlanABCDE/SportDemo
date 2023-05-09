package com.noob.sportsdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noob.sportsdemo.entity.Matchresult;
import com.noob.sportsdemo.entity.dto.MatchresultDTO;
import org.apache.ibatis.annotations.Update;

public interface MatchresultMapper extends BaseMapper<Matchresult> {
    @Update("update matchresult set match_status = #{matchStatus} , " +
            " match_score = #{matchScore} ," +
            " match_player = #{matchPlayer} ," +
            " match_rank= #{matchRank} where match_id = #{matchId}")
    int updateResultByStatus(MatchresultDTO matchresultDTO);
}
