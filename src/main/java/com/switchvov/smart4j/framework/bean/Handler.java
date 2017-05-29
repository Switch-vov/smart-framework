package com.switchvov.smart4j.framework.bean;

import com.switchvov.smart4j.framework.annotation.Action;
import com.switchvov.smart4j.framework.annotation.Controller;

import java.lang.reflect.Method;

/**
 * 封装Action信息
 * Created by Switch on 2017/5/27.
 */
public class Handler {
    /**
     * 带有{@link Controller}注解的类
     */
    private Class<?> controllerClass;

    /**
     * 带有{@link Action}注解的方法
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
