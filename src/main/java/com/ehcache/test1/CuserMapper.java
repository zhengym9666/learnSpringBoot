package com.ehcache.test1;

import com.ehcache.CUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;

@Mapper
@Primary
public interface CuserMapper {

    @Select("SELECT * FROM user_table WHERE username = #{username}")
    CUser findByName(@Param("username") String username);

}