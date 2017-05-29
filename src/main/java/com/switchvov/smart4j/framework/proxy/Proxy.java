package com.switchvov.smart4j.framework.proxy;

/**
 * 代理接口
 * Created by Switch on 2017/5/28.
 */
public interface Proxy {
    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
