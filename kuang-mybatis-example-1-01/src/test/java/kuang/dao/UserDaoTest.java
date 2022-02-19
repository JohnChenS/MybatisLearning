package kuang.dao;

import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author John Chen
 * @Date 202202
 */
public class UserDaoTest {
    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        
        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for(User user : userList){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //关于模糊查询怎么写，一是像如下的写法，传递通配符% %
        List<User> userList = mapper.getUserLike("%xl%");
        //另一种写法实在sql拼接中使用通配符
        //select * from kuang.user where name like "%"#{value}"%"
        // 注：本行是在在xml中，不是在Java文件里

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();


    }

    @Test
    public void getUserById(){
        //其中，头句和尾句为固定格式
        //而若增删改，则需要在close之前commit事务，此方法为“查”，不需要提交
        //头句如下
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(2);
        System.out.println(user);

        //尾句如下
        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(777,"cc","12589"));
        if(res > 0){
            System.out.println("insert successfully!");
            //提交事务非常重要
            sqlSession.commit();
        }

        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("userid", 5);
        map.put("password", "2333");

        mapper.addUser2(map);
        sqlSession.commit();

        //尾句如下
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(4,"fei","asd"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(4);

        sqlSession.commit();
        sqlSession.close();
    }
}
