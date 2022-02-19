package com.kuang.pojo;

import lombok.Data;

/**
 * @author John Chen
 * @Date 202202
 */

@Data
public class Student {

    private int id;
    private String name;

    private int tid;
    //学生需要关联一个老师
    private Teacher teacher;
/*
    p19复杂环境的搭建用到的sql语句
    CREATE TABLE `teacher` (
            `id` INT(10) NOT NULL,
  `name` VARCHAR(30) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

    INSERT INTO teacher(`id`, `name`) VALUES (1, '秦老师');

    CREATE TABLE `student` (
            `id` INT(10) NOT NULL,
  `name` VARCHAR(30) DEFAULT NULL,
  `tid` INT(10) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `fktid` (`tid`),
    CONSTRAINT `fktid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
            ) ENGINE=INNODB DEFAULT CHARSET=utf8INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('1', '小明', '1');
    INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('2', '小红', '1');
    INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('3', '小张', '1');
    INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('4', '小李', '1');
    INSERT INTO `student` (`id`, `name`, `tid`) VALUES ('5', '小王', '1');
*/
}
