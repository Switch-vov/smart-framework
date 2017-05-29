package com.switchvov.smart4j.framework.helper;

import com.switchvov.smart4j.framework.ConfigConstant;
import com.switchvov.smart4j.framework.utils.PropsUtils;

import java.util.Properties;

/**
 * 属性文件助手类
 * Created by Switch on 2017/5/27.
 */
public final class ConfigHelper {

    private static final Properties CONFIG_PROPS = PropsUtils.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取 JDBC 驱动
     */
    public static String getJdbcDriver() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取 JDBC URL
     */
    public static String getJdbcUrl() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    /**
     * 获取 JDBC 用户名
     */
    public static String getJdbcUsername() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取 JDBC 密码
     */
    public static String getJdbcPassword() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取应用基础包名
     */
    public static String getAppBasePackage() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取应用 JSP 路径
     */
    public static String getAppJspPath() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB-INF/view/");
    }

    /**
     * 获取应用静态资源路径
     */
    public static String getAppAssetPath() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/asset/");
    }

    /**
     * 获取应用文件上传限制
     */
    public static int getAppUploadLimit() {
        return PropsUtils.getInt(CONFIG_PROPS, ConfigConstant.APP_UPLOAD_LIMIT);
    }
}
