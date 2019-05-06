import cn.xxx.rpms.mapper.MaintenanceItemMapper;
import cn.xxx.rpms.query.MaintenanceItemQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class MaintenanceItemTest {
    @Autowired
    private MaintenanceItemMapper maintenanceItemMapper;
    //从明细到配件单
     @Test
      public void myTestForAll() throws Exception{
         maintenanceItemMapper.selectAll().forEach(e-> System.out.println(e));
      }
    //从明细到配件单 单个
     @Test
      public void myTestForOne() throws Exception{
         System.out.println(maintenanceItemMapper.selectByPrimaryKey(1L));
      }

     @Test
      public void myTest() throws Exception{
         MaintenanceItemQuery maintenanceItemBaseQuery=new MaintenanceItemQuery();
         maintenanceItemBaseQuery.setId(1L);
         maintenanceItemMapper.loadDataByQuery(maintenanceItemBaseQuery);
      }
}
