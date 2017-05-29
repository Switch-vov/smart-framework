package com.switchvov.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by Switch on 2017/5/28.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
