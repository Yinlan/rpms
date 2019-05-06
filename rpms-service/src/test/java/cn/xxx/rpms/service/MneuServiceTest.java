package cn.xxx.rpms.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class MneuServiceTest {
    @Autowired
    private IMenuService menuService;
     @Test
      public void myTest() throws Exception{
         menuService.selectSelfMenu(2L).forEach(e-> System.out.println(e));
      }

}
