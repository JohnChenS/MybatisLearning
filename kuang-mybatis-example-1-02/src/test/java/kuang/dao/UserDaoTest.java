package kuang.dao;

import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;



/**
 * @author John Chen
 * @Date 202202
 */
public class UserDaoTest {

    //提升作用域
    static org.apache.log4j.Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for(User user : userList){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void testLog4j(){

        //log4j的使用：
        // 1.先导入log4j的包
        // 2.从网上找log4j。properties的配置文件，放入resources后调整
        // 3.在mybatis-config.xml中配置log4j的实现
        // 4.static org.apache.log4j.Logger logger = Logger.getLogger(UserDaoTest.class);
        // 5.可以使用了

        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",1);
        map.put("pageSize",2);

        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUsers(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
