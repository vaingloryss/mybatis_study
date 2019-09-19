package com.vainglory.mapper;

import com.vainglory.domain.User;

import java.util.List;

/**
 * 传统开发方式，编写实现层
 */
public interface IUserDao {
    List<User> findAll();
    User findById(Integer id);
    void add(User user);
    void update(User user);
    void deleteById(Integer id);
    List<User> findByName(String name);
    Integer addReturnIndex(User user);
}
