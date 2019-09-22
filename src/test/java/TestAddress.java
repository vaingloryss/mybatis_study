import com.vainglory.domain.Address;
import com.vainglory.mapper.IAddressDao;
import com.vainglory.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestAddress {
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionUtils.openSqlSession();
        IAddressDao addressDao = sqlSession.getMapper(IAddressDao.class);
        List<Address> addresses = addressDao.findByUid(1);
        for (Address address : addresses) {
            System.out.println(address.toString());
        }
    }
}
