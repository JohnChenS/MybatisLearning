package com.kuang.dao;

import com.kuang.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author John Chen
 * @Date 202202
 */
public interface BlogMapper {

    //插入数据
    int addBlog(Blog blog);

    //查询博客（动态SQL语法）
    List<Blog> queryBlogIF(Map map);
    List<Blog> queryBlogChoose(Map map);
    List<Blog> queryBySQL(Map map);

    //更新博客
    int updateBlog(Map map);

    //查询第1、2、3号记录的博客（练习ForEach）
    List<Blog> queryBlogForeach(Map map);
}
