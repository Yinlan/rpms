import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.mapper.MaintenanceMapper;
import cn.xxx.rpms.mapper.MaintenancebuildMapper;
import cn.xxx.rpms.query.MaintenanceQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class MaintenanceTest {

    @Autowired
    private MaintenanceMapper maintenanceMapper;
    @Autowired
    private MaintenancebuildMapper maintenancebuildMapper;
    //测试从录入表--->找明细表--->找配件表
    //录入表--->维修人员
     @Test
      public void myTestForOpt() throws Exception{
         maintenanceMapper.selectAll().forEach(e-> System.out.println(e));
      }
        //测试从录入表--->找明细表--->找配件表 查询单个
       @Test
        public void myTestForOne() throws Exception{
           System.out.println(maintenanceMapper.selectByPrimaryKey(1L));
        }
        //测试从结算单找支付方式
         @Test
          public void myTestForMaintenancebuildMapper() throws Exception{
             maintenancebuildMapper.selectAll().forEach(e-> System.out.println(e));
          }
    //测试从结算单找支付方式 单个
         @Test
          public void myTestForMaintenancebuildMapperOne() throws Exception{
             System.out.println(  maintenancebuildMapper.selectByPrimaryKey(1L));
          }
           @Test
            public void myTestForQuery() throws Exception{
               MaintenanceQuery maintenanceQuery = new MaintenanceQuery();
               maintenanceQuery.setCarnum("云");
             maintenanceMapper.loadDataByQueryLimt(maintenanceQuery).forEach(e-> System.out.println(e));

           }

}
