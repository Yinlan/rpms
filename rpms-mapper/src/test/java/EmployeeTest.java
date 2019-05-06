import cn.xxx.rpms.domain.Employee;
import cn.xxx.rpms.domain.Role;
import cn.xxx.rpms.mapper.EmployeeMapper;
import cn.xxx.rpms.mapper.Employee_RoleMapper;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class EmployeeTest {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private Employee_RoleMapper employee_roleMapper;
    //员工到角色查询
     @Test
      public void myTestForManyRole() throws Exception{
//         employeeMapper.selectManyRole().forEach(e-> System.out.println(e));
      }
    //员工到角色查询 单独
     @Test
      public void myTestForOneRole() throws Exception{
         System.out.println(employeeMapper.selectManyRoleByID(2L));
      }
      //员工普通查询
       @Test
        public void myTestForAll() throws Exception{
           employeeMapper.selectAll().forEach(e-> System.out.println(e));
        }
        //员工新增
     @Test
      public void myTestForInsert() throws Exception{
         Employee employee = new Employee();
         employee.setName("龟田旭东");
         employee.setAge(20);
         employee.setEmail("165464@qq.com");
         employee.setTel(654484L);
         employeeMapper.insert(employee);
      }
       @Test
        public void myTestForDelete() throws Exception{
           Employee employee = employeeMapper.selectManyRoleByID(2L);
           List<Role> roles = employee.getRoles();

           employeeMapper.deleteByPrimaryKey(1L);

        }
         @Test
          public void myTest() throws Exception{
             Employee employee = new Employee();
             employee.setName("龟田旭东");
             employee.setAge(20);
             employeeMapper.insert(employee);
             System.out.println(employee.getId());
          }
           @Test
            public void myTest2() throws Exception{
               Employee employee = employeeMapper.selectByUserName("admin");
               System.out.println(employee);
           }
}
