package com.kuang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author John Chen
 * @Date 202202
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用Mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException E){
            E.printStackTrace();
        }
    }
    //既然有了SqlSessionFactory，顾名思义，我们就可以从中获得Sqlsession的实例了
    //SqlSession完全包含了面向数据库执行SQL命令所需的所有方法

    public static SqlSession getSqlSession(){
        //若带参为true，则为自动提交事务
        return sqlSessionFactory.openSession(true);
    }
}
