package com.haoer.common.condition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zengHao on 2020/08/14.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ICondition {

    /**
     * 是否为null 作为条件
     *
     * @return
     */
    boolean isNull() default false;

    /**
     * 查询sql的字段名(例: o.store_name)
     * @return
     */
    String name() default "";

    /**
     * 条件值
     *
     * @return
     */
    ConditionEnum value();

    /**
     * 条件:支持或值
     * @return
     */
    String orName() default "";
    String orValue() default "";
    int orIntValue() default -100;

}