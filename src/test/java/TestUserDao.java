import com.sun.org.apache.xpath.internal.SourceTree;
import com.vainglory.dao.IUserDao;
import com.vainglory.dao.daoImpl.UserDaoImpl;
import com.vainglory.domain.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TestUserDao {
    private static IUserDao userDao;
    @BeforeClass
    public static void testInit(){
        userDao = new UserDaoImpl();
    }

    /**
     * 查询所有
     */
    @Test
    public void test01(){
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    /**
     * 查询单个
     */
    @Test
    public void test02(){
        User user = userDao.findById(2);
        System.out.println(user.toString());
    }

    /**
     * 删除
     */
    @Test
    public void test03(){
        userDao.deleteById(7);
    }

    /**
     * 更新
     */
    @Test
    public void test04(){
        User user = new User(1,"Jack","男","123123123","123123@qq.com");
        userDao.update(user);
    }

    /**
     * 添加
     */
    @Test
    public void test05(){
        User user = new User(1,"Tom","男","234234","234234@qq.com");
        userDao.add(user);
    }

    /**
     * 根据用户名模糊查询
     */
    @Test
    public void test06(){
        List<User> userList = userDao.findByName("%Jac%");
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    /**
     * 插入并返回Last_insert_id
     */
    @Test
    public void test07(){
        User user = new User(0,"李太白","女","17687677887","123123@qq.com");
        Integer last_insert_id = userDao.addReturnIndex(user);
        System.out.println(user.getId());
        System.out.println(last_insert_id);
    }
}
