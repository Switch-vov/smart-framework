package com.switchvov.smart4j.framework.helper;

import com.switchvov.smart4j.framework.annotation.Controller;
import com.switchvov.smart4j.framework.annotation.Service;
import com.switchvov.smart4j.framework.utils.ClassUtils;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * 类操作助手类
 * Created by Switch on 2017/5/27.
 */
public final class ClassHelper {
    /**
     * 定义类集合(用于存放所加载的类)
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtils.getClassSet(basePackage);
    }

    /**
     * 获取应用包名下的所有诶
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取应用包名下所有Service类
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : CLASS_SET) {
            if (clazz.isAnnotationPresent(Service.class)) {
                classSet.add(clazz);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下所有的Controller类
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : CLASS_SET) {
            if (clazz.isAnnotationPresent(Controller.class)) {
                classSet.add(clazz);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下所有Bean类(包括：{@link Service}、{@link Controller}等)
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanClassSet = new HashSet<>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }

    /**
     * 获取应用包名下某父类(或接口)的所有子类(或实现类)
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : CLASS_SET) {
            if (superClass.isAssignableFrom(clazz) && !superClass.equals(clazz)) {
                classSet.add(clazz);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下带有某注解的所有类
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : CLASS_SET) {
            if (clazz.isAnnotationPresent(annotationClass)) {
                classSet.add(clazz);
            }
        }
        return classSet;
    }
}
