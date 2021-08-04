package cn.wolfcode.mybatis.dao.impl;

import cn.wolfcode.mybatis.dao.IUserDAO;
import cn.wolfcode.mybatis.domain.User;
import cn.wolfcode.mybatis.utils.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDAOImpl implements IUserDAO {

    @Override
    public void insert(User user) {
        SqlSession sqlSession = null;
        InputStream input = null;
        try {
            //1.load mybatis main configure document(mybatis-config.xml)
            input = Resources.getResourceAsStream("mybatis-config.xml");
            //2.create sqlSessionFactory object(DB conPool obj)
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(input);
            //3.create sqlSession obj(get DB con obj)
            sqlSession = sqlSessionFactory.openSession();
            //4.execute sql
            sqlSession.insert("cn.wolfcode.mybatis.mapper.UserMapper.insert", user);
            //5.commit sql(mybatis default open hand in transaction)
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //release resource
            sqlSession.close();
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User selectOne(Long userID) {
        SqlSession sqlSession = null;
        InputStream input = null;
        try {
            //1.load configure document
            input = Resources.getResourceAsStream("mybatis-config.xml");
            //2.create sqlSessionFactory obj
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(input);
            //3.create sqlSession obj
            sqlSession = sqlSessionFactory.openSession();
            //4.exe sql
            User user = sqlSession.selectOne("cn.wolfcode.mybatis.mapper.UserMapper.selectOne", userID);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //release resource
            sqlSession.close();
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<User> selectList() {
        List<User> users = null;
        try {
//            InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//            SqlSessionFactory sqlSessionFactory = builder.build(input);
//            SqlSession sqlSession = sqlSessionFactory.openSession();
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            users = sqlSession.selectList("cn.wolfcode.mybatis.mapper.UserMapper.selectAll");
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void delete(Long userID) {
        try{
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            sqlSession.delete("cn.wolfcode.mybatis.mapper.UserMapper.delete", userID);
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try{
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            sqlSession.delete("cn.wolfcode.mybatis.mapper.UserMapper.update", user);
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
