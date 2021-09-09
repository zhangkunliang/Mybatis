package com.zhang.dao;

import org.apache.ibatis.annotations.Select;
import com.zhang.pojo.User;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();
}
