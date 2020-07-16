package com.zjx.multiple.data.sources.annotation.config;

import java.lang.annotation.*;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/1 15:39
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value() default "DB1";

}
