package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author John Chen
 * @Date 202202
 */
public interface UserMapper {
    //根据id查询用户
    User queryUserById(@Param("id") int id);

    //更新
    int updateUser(User user);
}
