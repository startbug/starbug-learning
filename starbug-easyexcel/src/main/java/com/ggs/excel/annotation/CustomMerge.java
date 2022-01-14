package com.ggs.excel.annotation;

import java.lang.annotation.*;

/**
 * @Author lianghaohui
 * @Date 2022/1/14 15:59
 * @Description
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CustomMerge {

    /**
     * 是否需要合并单元格
     */
    boolean needMerge() default false;

    /**
     * 是否是主键,该字段相同的行合并
     */
    boolean isPk() default false;

}
