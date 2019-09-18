package com.vainglory.dao.daoImpl;

import com.vainglory.dao.IUserDao;
import com.vainglory.domain.User;
import com.vainglory.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Mybatis的两种开发方式
 * 第一种：原始方法
 */
public class UserDaoImpl implements IUserDao {
    SqlSession sqlSession = SqlSessionUtils.openSqlSession();
    @Override
    public List<User> findAll() {
        List<User> userList = sqlSession.selectList("test.findAll");
        sqlSession.close();
        return userList;
    }

    @Override
    public User findById(Integer id) {
        User user = sqlSession.selectOne("test.findById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public void add(User user) {
        sqlSession.insert("test.add",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(User user) {
        sqlSession.update("test.update",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteById(Integer id) {
        sqlSession.delete("test.deleteById",id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<User> findByName(String name) {
        List<User> userList = sqlSession.selectList("test.findByName", name);
        sqlSession.commit();
        sqlSession.close();
        return userList;
    }

    @Override
    public Integer addReturnIndex(User user) {
        int last_insert_id = sqlSession.update("test.addReturnIndex", user);
        sqlSession.commit();
        sqlSession.close();
        return last_insert_id;
    }
}
