package com.kuang.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author John Chen
 * @Date 202202
 */

@Data
public class Teacher {
    private int id;
    private String name;

    //一个老师对应多个学生
    private List<Student> students;
}
