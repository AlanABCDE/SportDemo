package com.noob.sportsdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noob.sportsdemo.entity.Playersheet;
import com.noob.sportsdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlayersheetMapper extends BaseMapper<Playersheet> {
    @Select("select * from playersheet  where username = #{username};")
    List<Playersheet> selectByUsername(@Param("username")String username);

}
