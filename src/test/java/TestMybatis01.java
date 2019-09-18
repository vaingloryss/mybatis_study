import com.vainglory.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestMybatis01 {
    private static SqlSession sqlSession;

    @BeforeClass
    public static void testInit(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有，返回List集合
     */
    @Test
    public void test01(){
        List<User> userList = sqlSession.selectList("test.findAll");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void test02(){
        User user = sqlSession.selectOne("test.findById",2);
        System.out.println(user.toString());
        sqlSession.close();
    }

    @Test
    public void test03(){
        //sqlSession中默认开启事务，执行增删改时一定要提交事务
        User user = new User(null,"Jack","男","123123123","123123@qq.com");
        int result = sqlSession.insert("test.add", user);
        sqlSession.commit();
        sqlSession.close();
        assertEquals(result,1);
    }
}
