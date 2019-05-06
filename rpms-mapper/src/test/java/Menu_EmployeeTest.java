import cn.xxx.rpms.mapper.Menu_EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class Menu_EmployeeTest {
    @Autowired
    private Menu_EmployeeMapper menu_employeeMapper;
     @Test
      public void myTest() throws Exception{
         menu_employeeMapper.selectByEid(1L).forEach(e-> System.out.println(e));
      }
}
