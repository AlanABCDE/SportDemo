package com.noob.sportsdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noob.sportsdemo.entity.User;
import com.noob.sportsdemo.entity.dto.UserPasswordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Update("update user set password = #{newPassword} where username = #{username} and password = #{password}")
    int updatePassword(UserPasswordDTO userPasswordDTO);
}
