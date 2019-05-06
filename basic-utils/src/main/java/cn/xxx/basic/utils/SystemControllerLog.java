package cn.xxx.basic.utils;

import java.lang.annotation.*;

/**
 * 自定义注解 拦截Controller
 *
 * @author lin.r.x
 *
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemControllerLog {
    /**
     * 描述业务操作 例:Xxx管理-执行Xxx操作
     * @return
     */
    String description() default "";
}