package cn.xxx.rpms.service;

import cn.xxx.rpms.shiro.MD5Util;
import org.junit.Test;

public class MD5Test {
     @Test
      public void myTest() throws Exception{
         System.out.println( MD5Util.getPWD("ar"));
      }
       @Test
        public void myTest2() throws Exception{
           System.out.println(MD5Util.breadkPWD("c582dec943ff7b743aa0691df291cea6\n"));
        }
}
