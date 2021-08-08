package cn.wolfcode.mybatis.mapper;

import cn.wolfcode.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {

    /**
     * add user
     */
    void addUser(User user);

    /**
     * log in
     * @param name
     * @param password
     * @return
     */
    User login(String name, String password);

    /**
     *
     * @param map
     * @return
     */
    User login1(Map<String,Object> map);

    /**
     *
     * @param userParam
     * @return
     */
    User login2(User userParam);

    /**
     *
     * @param name
     * @param password
     * @return
     */
    User login3(@Param("username")String name, @Param("password")String password);
}
