package com.switchvov.smart4j.framework;

import com.switchvov.smart4j.framework.helper.*;
import com.switchvov.smart4j.framework.utils.ClassUtils;

/**
 * 加载相应的Helper类
 * Created by Switch on 2017/5/27.
 */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> clazz : classList) {
            ClassUtils.loadClass(clazz.getName(), true);
        }
    }
}
