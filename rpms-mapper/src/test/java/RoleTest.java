import cn.xxx.basic.query.BaseQuery;
import cn.xxx.rpms.domain.Role;
import cn.xxx.rpms.mapper.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class RoleTest {
    @Autowired
    private RoleMapper roleMapper;
    //role到权限的多对多查询
     @Test
      public void myTestForMany() throws Exception{
         /*roleMapper.selectManyToPermission().forEach(e-> System.out.println(e));*/
      }
      //role到employee的多对多查询
       @Test
        public void myTestForManyToEmployee() throws Exception{
          /* roleMapper.selectManyToEmployee().forEach(e-> System.out.println(e));*/
        }
         @Test
          public void myTestForManyToEmployeeByID() throws Exception{
             System.out.println(roleMapper.selectManyToPermissionByID(1L));
          }
           @Test
            public void myTest() throws Exception{
//               Role role = roleMapper.selectManyToPermissionByID(1L);
               BaseQuery baseQuery = new BaseQuery();
               roleMapper.selectManyToPermission(baseQuery).forEach(e-> System.out.println(e));
           }
            @Test
             public void myTest2() throws Exception{
                Role role = new Role();
                role.setName("test3");
                int aLong = roleMapper.insertGetId(role);
                System.out.println(role.getId());
            }
             @Test
              public void myTest3() throws Exception{
                 roleMapper.selectAll().forEach(e-> System.out.println(e));
              }
}
