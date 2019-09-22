import com.vainglory.domain.Member;
import com.vainglory.mapper.IMemberDao;
import com.vainglory.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMember {
    /**
     * 测试一对多查询
     */
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionUtils.openSqlSession();
        IMemberDao memberDao = sqlSession.getMapper(IMemberDao.class);
        Member member = memberDao.findByUidAndAid(1);
        System.out.println(member.toString());
    }

    /**
     * 测试延迟加载
     */
    @Test
    public void test02(){
        SqlSession sqlSession = SqlSessionUtils.openSqlSession();
        IMemberDao memberDao = sqlSession.getMapper(IMemberDao.class);
        Member member = memberDao.findByUid(1);
        /**
         * 一旦调用member的toString、hashCode、clone、equals方法
         * 被关联的查询便会被调用
         */
        System.out.println(member.toString());
    }
}
