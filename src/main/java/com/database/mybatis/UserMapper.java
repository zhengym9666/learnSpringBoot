package com.database.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//mapper要在启动类中被扫描到才能使用
//@Repository
public interface UserMapper{

    @Select("SELECT * FROM user_table WHERE username = #{username}")
    User findByName(@Param("username") String username);
    @Insert("INSERT INTO USERS(id,username, password) VALUES(5,#{name}, #{pwd})")
    int insert(@Param("name") String name, @Param("pwd") String pwd);

}
