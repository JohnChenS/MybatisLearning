package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author John Chen
 * @Date 202202
 */

//需要建一个xml
public interface UserMapper {
    //查询所有用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //模糊查询
    List<User> getUserLike(String value);

    //用map来查询
    User getUserById2(Map<String, Object> map);

    //insert一个用户
    int addUser(User user);

    int addUser2(Map<String, Object> map);

    //用map来去insert
    int addUser(Map<String,Object> map);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);


}
