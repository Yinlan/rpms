package cn.xxx.rpms.service;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.MaintenanceItem;
import cn.xxx.rpms.query.MaintenanceItemQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class MaintenanceItemServiceTest {
    @Autowired
    private IMaintenanceItemService maintenanceItemService;
     @Test
      public void myTest() throws Exception{
         MaintenanceItemQuery maintenanceItemBaseQuery=new MaintenanceItemQuery();
         maintenanceItemBaseQuery.setId(1L);
         PageList<MaintenanceItem> maintenanceItemPageList = maintenanceItemService.queryPage(maintenanceItemBaseQuery);
         maintenanceItemPageList.getRows().forEach(e-> System.out.println(e));
     }
}
