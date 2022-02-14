package cn.henry.common.annotation;

import java.lang.annotation.*;

/**
 * bean判空
 * 不可为空属性可加该注解
 *
 * @author Henry
 * @date 2022-02-12 22:48
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequiredParam {
    /**
     * 默认不可为空
     */
    boolean isNotBlank() default true;
}
