import cn.xxx.rpms.mapper.OptMapper;
import cn.xxx.rpms.query.OptQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class OptTest {
    @Autowired
    private OptMapper optMapper;
     @Test
      public void myTest() throws Exception{
         OptQuery optQuery = new OptQuery();
         optQuery.setOptname("维修员四");
         SimpleDateFormat sdf = new SimpleDateFormat( " yyyy-MM-dd" );
         Date parse = sdf.parse(" 2019-03-01");
         optQuery.setBignDate(parse);
         Date parse1 = sdf.parse(" 2019-04-12");
         optQuery.setEndDate(parse1);
         optMapper.loadDataByQueryLimt(optQuery).forEach(e-> System.out.println(e));
      }
}
