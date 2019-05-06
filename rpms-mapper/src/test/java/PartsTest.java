import cn.xxx.rpms.domain.Parts;
import cn.xxx.rpms.mapper.PartsMapper;
import cn.xxx.rpms.query.PartsQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class PartsTest {
    @Autowired
    private PartsMapper partsMapper;
     @Test
      public void myTest() throws Exception{
         PartsQuery partsQuery = new PartsQuery();
         partsQuery.setPartsname("轮胎");
         Parts parts = partsMapper.checkNameQuery(partsQuery);
         System.out.println(parts);

     }
}
