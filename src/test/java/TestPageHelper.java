import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vainglory.domain.User;
import com.vainglory.mapper.IUserDao;
import com.vainglory.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestPageHelper {
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionUtils.openSqlSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        PageHelper.startPage(1,4);
        PageHelper.orderBy("id desc");//按照id降序排列，asc 升序
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
        //包装一个PageInfo，其中会持有所有分页会用到的信息：
        // 当前页号，每页多少条，共多少页，是否为第一页/最后一页，是否有下一页等。
        PageInfo<User> pageInfo = new PageInfo(users);
        System.out.println(pageInfo.toString());
    }
}
