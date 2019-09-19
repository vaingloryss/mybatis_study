import com.vainglory.domain.User;
import com.vainglory.domain.vo.QueryVo;
import com.vainglory.mapper.IUserDynamicSqlDao;
import com.vainglory.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.InflaterInputStream;

public class TestUserDynamicDao {

    /**
     * 发现问题
     */
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionUtils.openSqlSession();
        IUserDynamicSqlDao userDynamicSqlDao = sqlSession.getMapper(IUserDynamicSqlDao.class);
        User user = new User();
        user.setGender("男");
        //user.setName("Jack");
        List<User> userList = userDynamicSqlDao.findByWhere(user);
        for (User user1 : userList) {
            System.out.println(user1.toString());
        }
        /*
        测试查看结果
        如果注释掉user.setSex(1)
        再次测试发现问题。gender参数为空，返回结果为0
        按照之前所学的，要解决这个问题，需要编写多个sql，查询条件越多，需要编写的sql就更多了，显然这样是不靠谱的。
        解决方案，使用动态sql的if标签
         */
    }

    /**
     * 测试findByQueryVo
     */
    @Test
    public void test02(){
        List<Integer> ids = new ArrayList<>();
        ids.add(8);
        ids.add(11);
        ids.add(10);

        QueryVo queryVo = new QueryVo();
        System.out.println(ids);
        queryVo.setIds(ids);

        SqlSession sqlSession = SqlSessionUtils.openSqlSession();
        IUserDynamicSqlDao userDynamicSqlDao = sqlSession.getMapper(IUserDynamicSqlDao.class);
        List<User> userList = userDynamicSqlDao.findByVo(queryVo);
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }


}
