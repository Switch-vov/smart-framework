package com.switchvov.smart4j.framework.helper;

import com.switchvov.smart4j.framework.utils.ReflectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean助手类
 * Created by Switch on 2017/5/27.
 */
public final class BeanHelper {
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtils.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    /**
     * 获取Bean映射
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取Bean实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {
        if (!BEAN_MAP.containsKey(clazz)) {
            throw new RuntimeException("can not get bean by class: " + clazz);
        }
        return (T) BEAN_MAP.get(clazz);
    }

    /**
     * 设置Bean实例
     */
    public static void setBean(Class<?> clazz, Object obj) {
        BEAN_MAP.put(clazz, obj);
    }
}
