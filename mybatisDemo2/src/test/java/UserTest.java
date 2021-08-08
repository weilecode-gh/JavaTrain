import cn.wolfcode.mybatis.domain.User;
import cn.wolfcode.mybatis.mapper.UserMapper;
import cn.wolfcode.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class UserTest {

    @Test
    public void addUserTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        /*
         * call getMapper(),send UserMapper interface bytecode
         * 1.getMapper() return a UserMapper interface implementation class object
         * the object created by jdk dynamic agent
         * 2.why we send UserMapper interface bytecode object?
         * because with the project getting bigger,we will create many mapper interface
         * after mybatis loaded,it will create many mapper interface implementation class object
         * mybatis will put mapper interface and implement class into a map
         * key:interface bytecode obj              value:interface implementation class object
         * 3.
         */
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //create User obj,encapsulate data
        User user = new User();
        user.setName("wuyi");
        user.setAge(19);
        user.setSalary(new BigDecimal(10000));
        user.setHiredate(new Date());
        user.setPassword("2333");

        userMapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void loginTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    }

    @Test
    public void login1Test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    }

    @Test
    public void login2Test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User userParam = new User();
        userParam.setName("wusi");
        userParam.setPassword("2333");
        userMapper.login2(userParam);
        System.out.println(userParam);
    }

    @Test
    public void login3Test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.login3("wusi","2333");
        System.out.println(user);
    }
}
