package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author John Chen
 * @Date 202202
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//解决：Cause: java.io.NotSerializableException: com.kuang.pojo.User
//问题：我们需要将实体类序列化！否则会报如上错误
public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;
}
