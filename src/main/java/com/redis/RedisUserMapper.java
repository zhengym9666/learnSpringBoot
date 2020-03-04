package com.redis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RedisUserMapper {

    @Select("SELECT * FROM user_table WHERE id = #{id}")
    RedisUser findById(@Param("id") int id);

}
