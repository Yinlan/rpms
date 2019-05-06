import cn.xxx.rpms.domain.Employee;
import cn.xxx.rpms.domain.User;
import cn.xxx.rpms.mapper.EmployeeMapper;
import cn.xxx.rpms.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class UserTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
     @Test
      public void myTest() throws Exception{
         User user = userMapper.selectByOpenid("oa9wA0-3lf0bu9XClm6znMq9l60E");
         System.out.println(user);
         Employee employee = employeeMapper.selectManyRoleByID(user.getEid());
         System.out.println(employee);

     }
}
