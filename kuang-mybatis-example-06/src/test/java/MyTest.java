import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author John Chen
 * @Date 202202
 */
public class MyTest {

    @Test
    public void queryUserById(){
        /*总结：
         * 一级缓存默认是开启的，只在一次SqlSession中有效，也就是拿到连接到关闭连接这个区间
         * 每个用户拿到一个自己的SqlSession，然后在这段时间里面，除非查询同一个数据，会用到这个缓存（前提是你不要手动去清，也不要在这
         * 两个查询之间去修改、删除数据库的数据，此时就能用到一级缓存）
         * */
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //先查一次id为“1”的
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);

        //再查一次id为“1”的
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user1 == user2);
        sqlSession.close();

        /*
        输出结果如下：
        Opening JDBC Connection
        Created connection 266437232.
        ==>  Preparing: select * from kuang.user where id = ?
        ==> Parameters: 1(Integer)
        <==    Columns: id, name, pwd
        <==        Row: 1, zhu, wwww
        <==      Total: 1
        User(id=1, name=zhu, pwd=wwww)
        User(id=1, name=zhu, pwd=wwww)
        true
        Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@fe18270]
        Returned connection 266437232 to pool.

        分析：Session中查相同记录
            Sqlsession的缓存
            只查了一次
        */
    }

    @Test
    public void queryUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //先查一次id为“1”的
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);

        //更新
        mapper.updateUser(new User(2,"xlmm","aiyh"));

        //再查一次id为“1”的
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user1 == user2);
        sqlSession.close();

        /*
        输出结果如下：
        Opening JDBC Connection
        Created connection 266437232.
   ->   ==>  Preparing: select * from kuang.user where id = ?
        ==> Parameters: 1(Integer)
        <==    Columns: id, name, pwd
        <==        Row: 1, zhu, wwww
        <==      Total: 1
        User(id=1, name=zhu, pwd=wwww)
        ==>  Preparing: update kuang.user set name = ?, pwd = ? where id = ?;
        ==> Parameters: xlmm(String), aiyh(String), 2(Integer)
        <==    Updates: 1
   ->   ==>  Preparing: select * from kuang.user where id = ?
        ==> Parameters: 1(Integer)
        <==    Columns: id, name, pwd
        <==        Row: 1, zhu, wwww
        <==      Total: 1
        User(id=1, name=zhu, pwd=wwww)
        false
        Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@fe18270]
        Returned connection 266437232 to pool.

        分析：
        中间多了一个更新，但前后的查询查同一个id需要查两次，虽然更新与查询的不一样
        */
    }

    @Test
    public void queryUserById3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //先查一次id为“1”的
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);

        //清理缓存
        sqlSession.clearCache();

        //再查一次id为“1”的
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user1 == user2);
        sqlSession.close();

        /*
        输出结果如下：
        Opening JDBC Connection
        Created connection 266437232.
        ==>  Preparing: select * from kuang.user where id = ?
        ==> Parameters: 1(Integer)
        <==    Columns: id, name, pwd
        <==        Row: 1, zhu, wwww
        <==      Total: 1
        User(id=1, name=zhu, pwd=wwww)
        ==>  Preparing: select * from kuang.user where id = ?
        ==> Parameters: 1(Integer)
        <==    Columns: id, name, pwd
        <==        Row: 1, zhu, wwww
        <==      Total: 1
        User(id=1, name=zhu, pwd=wwww)
        false
        Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@fe18270]
        Returned connection 266437232 to pool.

        分析：
        清理缓存后，也查了两次

        */
    }


    @Test
    public void queryUserById4(){

        //先搞出两个sqlSession
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.queryUserById(1);
        System.out.println(user1);
        sqlSession1.close();

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user1 == user2);
        sqlSession2.close();

        /*
        输出结果如下：
        Opening JDBC Connection
        Created connection 1988859660.
        ==>  Preparing: select * from kuang.user where id = ?
        ==> Parameters: 1(Integer)
        <==    Columns: id, name, pwd
        <==        Row: 1, zhu, wwww
        <==      Total: 1
        User(id=1, name=zhu, pwd=wwww)
        Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@768b970c]
        Returned connection 1988859660 to pool.

        分析：
        两个不同的sqlSwssion，开启了二级缓存，当一个关闭了，另一个查一样的东西，还是能从二级缓存查出来

        总结：
        只要开启了二级缓存，在同一个Mapper下就有效
        所有的数据都会先放在一级缓存中
        只有当会话提交，或者关闭的时候，才会提交到二级缓存中

        */
    }
}
