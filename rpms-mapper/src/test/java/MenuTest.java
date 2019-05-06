import cn.xxx.basic.query.BaseQuery;
import cn.xxx.rpms.domain.Menu;
import cn.xxx.rpms.domain.Permission;
import cn.xxx.rpms.mapper.MenuMapper;
import cn.xxx.rpms.mapper.PermissionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class MenuTest {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    //自连接查询
     @Test
      public void myTestForOneToOne() throws Exception{
         List<Menu> menus = menuMapper.selectAll();
         System.out.println(menus);
     }
      @Test
       public void myTestForPermission() throws Exception{
          permissionMapper.selectAll().forEach(e-> System.out.println(e));
       }
        @Test
         public void myTestForUpdate() throws Exception{
            BaseQuery baseQuery = new BaseQuery();


            menuMapper.selectSelfNoQuery().forEach(e-> System.out.println(e));

        }
         @Test
          public void myTest() throws Exception{
             BaseQuery baseQuery = new BaseQuery();
             menuMapper.loadDataByQuery(baseQuery).getResult().forEach(e-> System.out.println(e));
          }
           @Test
            public void myTest2() throws Exception{
                menuMapper.selectParent().forEach(e-> System.out.println(e));
            }
             @Test
              public void myTest3() throws Exception{
                 menuMapper.selectSelfById(9L).forEach(e-> System.out.println(e));
              }

}
