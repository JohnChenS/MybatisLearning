package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author John Chen
 * @Date 202202
 */

@Alias("user")

//lombok的使用步骤：1.在IDEA的setting中安装插件
//2.在pom.xml中导入依赖
//3.写关于想要实现的功能的相关注解，如下演示

//以下为lombok注解
//Data中直接自动生成无参构造、get、set、toString、hashCode、equals
@Data
//有参
@AllArgsConstructor
//无参，若只写@AllArgsConstructor时，
// 无参就会消失，所以要写上@NoArgsConstructor
@NoArgsConstructor

public class User {
    private int id;
    private String name;
    private  String pwd;


//     使用lombok就不需要以下代码了，可以偷懒自动生成
//    public User() {
//    }
//
//    public User(int id, String name, String pwd) {
//        this.id = id;
//        this.name = name;
//        this.pwd = pwd;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPwd() {
//        return pwd;
//    }
//
//    public void setPwd(String pwd) {
//        this.pwd = pwd;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", pwd='" + pwd + '\'' +
//                '}';
//    }
}
