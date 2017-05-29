package com.switchvov.smart4j.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 切面代理
 * Created by Switch on 2017/5/28.
 */
public abstract class AspectProxy implements Proxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public final Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;

        Class<?> clazz = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();

        begin();
        try {
            if (intercept(clazz, method, params)) {
                before(clazz, method, params);
                result = proxyChain.doProxyChain();
                after(clazz, method, params, result);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Exception e) {
            LOGGER.error("proxy failure", e);
            error(clazz, method, params, e);
            throw e;
        } finally {
            end();
        }
        return result;
    }


    /**
     * 增强前的操作
     */
    public void begin() {

    }

    /**
     * 环绕增强
     */
    public boolean intercept(Class<?> clazz, Method method, Object[] params) throws Throwable {
        return true;
    }

    /**
     * 前置增强
     */
    public void before(Class<?> clazz, Method method, Object[] params) throws Throwable {

    }

    /**
     * 后置增强
     */
    public void after(Class<?> clazz, Method method, Object[] params, Object result) throws Throwable {

    }

    /**
     * 抛出增强
     */
    public void error(Class<?> clazz, Method method, Object[] params, Throwable e) {

    }


    /**
     * 增强后的操作
     */
    public void end() {

    }
}
