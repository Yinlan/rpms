package cn.xxx.controller;

import cn.xxx.client.IMantenanceServiceCXF;
import cn.xxx.client.Maintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientController {
  @RequestMapping("/get")
  @ResponseBody
    private Maintenance get(Long id){
      System.out.println(id);
      ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-cxf-client.xml");
      String[] beanDefinitionNames =
              context.getBeanDefinitionNames();
      for (String beanDefinitionName : beanDefinitionNames) {
          System.out.println(beanDefinitionName);
      }
      //从spring环境中获取bean，强转
      IMantenanceServiceCXF helloClient = (IMantenanceServiceCXF) context.getBean("helloClient");
      System.out.println(helloClient.getClass());//动态代理
      Maintenance maintenance = (Maintenance) helloClient.get(id);

      System.out.println(maintenance);//就像调用本地服务一样调用远程服务
      return maintenance;
  }
}
