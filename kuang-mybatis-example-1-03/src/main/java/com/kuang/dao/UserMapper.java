package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author John Chen
 * @Date 202202
 */

//需要建一个xml
public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数，所有的参数前面必须加上@Param("id")注解
//    基本类型的参数或String类型，需要加上
//    应用类型不需要加
//    如果只有一个基本类型的话可以忽略，但是建议加上
//    我们在SQL中应用的就是我们这里的@Param()中设置的属性名
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);

    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);

    @Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
    int updateUser(User user);

}
