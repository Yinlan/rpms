import cn.xxx.basic.query.BaseQuery;
import cn.xxx.rpms.domain.Permission;
import cn.xxx.rpms.mapper.PermissionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class PermissionTest {
    @Autowired
    private PermissionMapper permissionMapper;
     @Test
      public void myTestForMany() throws Exception{
//  permissionMapper.selectManyRole();
//         Permission permission = new Permission();
//         permission.setMenuId(1L);
//         permission.setName("6666");
//         permissionMapper.insert(permission);
         BaseQuery baseQuery = new BaseQuery();
         baseQuery.setLimit(50);
         permissionMapper.loadDataByQuery(baseQuery).forEach(e-> System.out.println(e));
      }
       @Test
        public void myTest() throws Exception{
           permissionMapper.selectAll().forEach(e-> System.out.println(e));
        }
         @Test
          public void myTest2() throws Exception{
             Permission permission = permissionMapper.selectByPrimaryKey(1L);
             System.out.println(permission);

         }

}
