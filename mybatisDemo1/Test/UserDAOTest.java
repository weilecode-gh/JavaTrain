import cn.wolfcode.mybatis.dao.IUserDAO;
import cn.wolfcode.mybatis.dao.impl.UserDAOImpl;
import cn.wolfcode.mybatis.domain.User;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserDAOTest {
    private final IUserDAO userDAO = new UserDAOImpl();
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("chenqi");
        user.setAge(19);
        user.setSalary(new BigDecimal(20000));
        user.setHiredate(new Date());
        userDAO.insert(user);
    }

    @Test
    public void selectOneTest(){
        Long userid = 2L;
        User user = userDAO.selectOne(userid);
        System.out.println(user);
    }

    @Test
    public void selectAll(){
        List<User> users = userDAO.selectList();
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void delete(){
        Long userid = 4L;
        userDAO.delete(userid);
    }

    @Test
    public void update(){
        User user1 = new User();
        user1.setId(1L);
        user1.setName("zhoushi");
        user1.setAge(18);
        user1.setSalary(new BigDecimal(18000));
        user1.setHiredate(new Date());
        userDAO.update(user1);
    }
}
