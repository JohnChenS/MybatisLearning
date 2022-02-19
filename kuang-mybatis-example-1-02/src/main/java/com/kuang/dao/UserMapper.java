package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Select;

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

    //分页
    List<User> getUserByLimit(Map<String, Integer> map);

    @Select("select * from user")
    List<User> getUsers();


}
