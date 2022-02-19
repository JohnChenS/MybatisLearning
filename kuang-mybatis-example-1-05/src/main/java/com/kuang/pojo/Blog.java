package com.kuang.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author John Chen
 * @Date 202202
 */
@Data
public class Blog {

    private String id;
    private String title;
    private  String author;
    private Date createTime;  //与数据库名不一致，注意mybatis-config.xml中的setting中的驼峰映射
    private int views;

    /*
    数据库中：
    CREATE TABLE `blog`(
`id` VARCHAR(50) NOT NULL COMMENT '博客id',
`title` VARCHAR(100) NOT NULL COMMENT '博客标题',
`author` VARCHAR(30) NOT NULL COMMENT '博客作者',
`create_time` DATETIME NOT NULL COMMENT '创建时间',
`views` INT(30) NOT NULL COMMENT '浏览量'
)ENGINE=INNODB DEFAULT CHARSET=utf8;
*/
}
