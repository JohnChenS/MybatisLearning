package com.kuang.dao;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author John Chen
 * @Date 202202
 */
public interface TeacherMapper {
    @Select("select * from teacher where id=#{tid}")
    Teacher getTeacher(@Param("tid") int id);

    public Teacher getTeacher1(@Param("tid") int tid);

    public Teacher getTeacher2(@Param("tid") int tid);
}
