package com.vainglory.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {

    private static SqlSessionFactory sqlSessionFactory;

    /*单例模式的SqlSessionFactory*/
    /*public static synchronized SqlSessionFactory getInstance(InputStream is){
        if (null==sqlSessionFactory){
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }
        return sqlSessionFactory;
    }*/

    static {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSession openSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
