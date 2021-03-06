import com.vainglory.domain.Worker;
import com.vainglory.mapper.IWorkerDao;
import com.vainglory.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

public class TestWorkerDao {
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
     * 查询所有
     */
    @Test
    public void test01(){
        IWorkerDao workerDao = sqlSession.getMapper(IWorkerDao.class);
        List<Worker> workerList = workerDao.findAll();
        sqlSession.close();
        for (Worker worker : workerList) {
            System.out.println(worker.toString());
        }
    }

    @Test
    public void test02(){
        Worker worker = new Worker(0,"杜甫",new BigDecimal(12300.0),"长安");
        IWorkerDao workerDao = sqlSession.getMapper(IWorkerDao.class);
        workerDao.add(worker);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 测试@Param
     */
    @Test
    public void test03(){
        SqlSession sqlSession = SqlSessionUtils.openSqlSession();
        IWorkerDao workerDao = sqlSession.getMapper(IWorkerDao.class);
        List<Worker> workerList = workerDao.findByNameAndAddress("%ac%", "天津");
        for (Worker worker : workerList) {
            System.out.println(worker.toString());
        }
    }

    /**
     * 获取数据库数据的个数
     */
    @Test
    public void test04(){
        SqlSession sqlSession = SqlSessionUtils.openSqlSession();
        IWorkerDao workerDao = sqlSession.getMapper(IWorkerDao.class);
        Long count = workerDao.getCount();
        System.out.println(count);
    }
}
