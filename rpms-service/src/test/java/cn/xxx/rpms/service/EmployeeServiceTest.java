package cn.xxx.rpms.service;

import cn.xxx.rpms.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class EmployeeServiceTest {
    @Autowired
    private IEmployeeService employeeService;
     @Test
      public void myTest() throws Exception{
         employeeService.selectManyRoleByID(1L).forEach(e-> System.out.println(e));
     }
}
