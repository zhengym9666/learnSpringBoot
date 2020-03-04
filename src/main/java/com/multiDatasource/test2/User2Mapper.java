package com.multiDatasource.test2;

import com.multiDatasource.entity.User1;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//mapper要在启动类中被扫描到才能使用
@Mapper
public interface User2Mapper {

    @Select("SELECT * FROM user2 WHERE username = #{username}")
    User1 findByName(@Param("username") String username);
    @Insert("INSERT INTO user2(id,username, password) VALUES(5,#{name}, #{pwd})")
    int insert(@Param("name") String name, @Param("pwd") String pwd);

}
