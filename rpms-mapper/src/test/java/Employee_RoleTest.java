import cn.xxx.rpms.domain.Employee_Role;
import cn.xxx.rpms.mapper.Employee_RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class Employee_RoleTest {
    @Autowired
    private Employee_RoleMapper employee_roleMapper;
     @Test
      public void myTestForInsert() throws Exception{
         Employee_Role employee_role = new Employee_Role();
         employee_role.setEmployeeId(3L);
         employee_role.setRoleId(3L);
         employee_roleMapper.insert(employee_role);

      }
       @Test
        public void myTestForUpdate() throws Exception{
           Employee_Role employee_role = new Employee_Role();
           employee_role.setEmployeeId(3L);
           employee_role.setRoleId(7L);
           employee_role.setId(4L);
//           employee_roleMapper.updateByPrimaryKey(employee_role);

        }
         @Test
          public void myTestForSelect() throws Exception{
             Employee_Role employee_role = new Employee_Role();
             employee_role.setEmployeeId(3L);
             employee_role.setRoleId(4L);
             Employee_Role employee_role1 = employee_roleMapper.selectIdByEidAndRid(employee_role);
             System.out.println(employee_role1);
         }
          @Test
           public void myTest() throws Exception{
              Employee_Role employee_role = new Employee_Role();
              employee_role.setEmployeeId(9L);
              employee_role.setRoleId(1L);
              employee_roleMapper.deleteByEidAndRid(employee_role);
           }
}
