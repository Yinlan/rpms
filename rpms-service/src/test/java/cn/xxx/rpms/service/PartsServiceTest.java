package cn.xxx.rpms.service;

import cn.xxx.basic.utils.LuceneUtil;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Parts;
import cn.xxx.rpms.query.PartsQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class PartsServiceTest {
    @Autowired
    private IPartsService partsService;
     @Test
      public void myTestForAll() throws Exception{
         partsService.getAll().forEach(e-> System.out.println(e));
      }
       @Test
        public void myTestForCheck() throws Exception{
           PartsQuery partsQuery = new PartsQuery();
           partsQuery.setPartsname("轮胎");
           partsQuery.setPid(1L);
           Boolean aBoolean = partsService.checkNameQuery(partsQuery);
           if(aBoolean){
               System.out.println("未查询到 可以使用");
           }else{
               System.out.println("查询得到 有待考虑或者空");
           }
       }
        @Test
         public void myTestForlucence() throws Exception{
            LuceneUtil.deleteAllIndex();
            partsService.updateIndex();
            PartsQuery partsQuery = new PartsQuery();
            partsQuery.setPartsname("玻璃水");
            partsQuery.setLimit(10);
            partsQuery.setPage(1);
            PageList<Parts> byQuery = partsService.getByQuery(partsQuery);
            byQuery.getRows().forEach(e-> System.out.println(e));
        }
}
