package cn.xxx.rpms.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 设置 加盐 加密次数的加密工具
 */
public class MD5Util {
    //设置常量盐值
    public static final String SALT ="xxx";
    //设置常量加密次数
    public static final int HASHITERATIONS=10;
    public static String getPWD(String pwd){
        SimpleHash simpleHash = new SimpleHash("MD5",pwd,SALT,HASHITERATIONS);
        return simpleHash.toString();
    }
    public static  String breadkPWD(String pwd){
        char[] charArray = pwd.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ 't');
        }
        String str = String.valueOf(charArray);
        return str;
    }
}
