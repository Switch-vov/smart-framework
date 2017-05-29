package com.switchvov.smart4j.framework.helper;

import com.switchvov.smart4j.framework.annotation.Inject;
import com.switchvov.smart4j.framework.utils.ArrayUtil;
import com.switchvov.smart4j.framework.utils.CollectionUtil;
import com.switchvov.smart4j.framework.utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 * Created by Switch on 2017/5/27.
 */
public final class IocHelper {

    static {
        // 获取所有的Bean类与Bean实例之间的映射关系(简称Bean Map)
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            // 遍历Bean Map
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                // 从BeanMap中获取Bean类与Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                // 获取Bean类定义的所有成员变量(简称Bean Field)
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    // 遍历Bean Field
                    for (Field beanField : beanFields) {
                        // 判断当前Bean Field是否带有Inject注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            // 在Bean Map中获取Bean Field对应的实例
                            Class<?> beanFieldType = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldType);
                            if (beanFieldInstance != null) {
                                // 通过反射初始化 BeanField的值
                                ReflectionUtils.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
