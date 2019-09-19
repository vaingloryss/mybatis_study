package com.vainglory.mapper;

import com.vainglory.domain.User;
import com.vainglory.domain.vo.QueryVo;

import java.util.List;

/**
 * 动态Sql
 */
public interface IUserDynamicSqlDao {
    //发现问题
    List<User> findByWhere(User user);
    List<User> findByWhereI(User user);
    List<User> findByVo(QueryVo queryVo);
}
