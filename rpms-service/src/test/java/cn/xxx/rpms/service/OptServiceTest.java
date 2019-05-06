package cn.xxx.rpms.service;

import cn.xxx.rpms.query.OptQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class OptServiceTest {
    @Autowired
    private IOptService optService;
     @Test
      public void myTestForAll() throws Exception{
         optService.getAll().forEach(e-> System.out.println(e));
      }
       @Test
        public void myTest() throws Exception{
           OptQuery optQuery = new OptQuery();
           optQuery.setOptname("维修员四");
           SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
           Date parse = sdf.parse(" 2019-03-01");
           optQuery.setBignDate(parse);
           Date parse1 = sdf.parse(" 2019-04-11");
           optQuery.setEndDate(parse1);
           optService.loadDataByQueryLimt(optQuery).getRows().forEach(e-> System.out.println(e));
        }
         @Test
          public void myTest2() throws Exception{
             String substring = "/upload/59c3.jpg".substring(7, 16);
             System.out.println(substring);
         }
}
