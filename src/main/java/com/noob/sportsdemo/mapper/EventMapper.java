package com.noob.sportsdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noob.sportsdemo.entity.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EventMapper extends BaseMapper<Event> {

    @Select("select * from event  where event_holder = #{eventHolder};")
    List<Event> selectByEventHolder(@Param("eventHolder")String eventHolder);
}
