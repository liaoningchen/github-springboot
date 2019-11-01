package com.springboot.myexception.annotation;

import java.lang.annotation.*;

/**
 * @author chendeyou 2019/11/1 16:28
 * @ClassName: com.springboot.myexception.annotation
 * @describe
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CommonLog {
    String value() default "";
}
