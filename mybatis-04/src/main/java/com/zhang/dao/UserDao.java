package com.zhang.dao;

import com.zhang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getUserLike(String value);
    List<User> getUserList();
    int insertUser(User user);
    User getUserById(Map<String ,Object> map);
    List<User> selectUser(Map<String,Integer> map);
}
