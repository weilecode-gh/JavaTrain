package cn.wolfcode.mybatis.dao;

import cn.wolfcode.mybatis.domain.User;

import java.util.List;

public interface IUserDAO {
    /**
     * 记录用户信息
     * @param user
     */
    public void insert(User user);

    /**
     *
     */
    public User selectOne(Long userID);

    /**
     *
     */
    List<User> selectList();

    void delete(Long userID);

    void update(User user);
}
