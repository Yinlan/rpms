import cn.xxx.rpms.domain.Role_Permission;
import cn.xxx.rpms.mapper.Role_PermissionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class Role_PermissonTest {
    @Autowired
    private Role_PermissionMapper role_permissionMapper;
     @Test
      public void myTest() throws Exception{
         Role_Permission role_permission = new Role_Permission();
         role_permission.setRoleId(6L);
         role_permission.setPermissionId(1L);
         role_permissionMapper.deleteByPidAndRid(role_permission);
      }
}
