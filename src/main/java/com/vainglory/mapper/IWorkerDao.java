package com.vainglory.mapper;

import com.vainglory.domain.User;
import com.vainglory.domain.Worker;

import java.util.List;

/**
 * Mybatis动态代理方式
 */
public interface IWorkerDao {
    List<Worker> findAll();
    Worker findById(Integer id);
    void add(Worker worker);
    void update(Worker worker);
    void deleteById(Integer id);
}
