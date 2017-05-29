package com.switchvov.smart4j.framework.helper;

import com.switchvov.smart4j.framework.bean.FormParam;
import com.switchvov.smart4j.framework.bean.Param;
import com.switchvov.smart4j.framework.utils.ArrayUtil;
import com.switchvov.smart4j.framework.utils.CodeUtils;
import com.switchvov.smart4j.framework.utils.StreamUtils;
import com.switchvov.smart4j.framework.utils.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 请求助手类
 * Created by Switch on 2017/5/28.
 */
public final class RequestHelper {
    /**
     * 创建请求对象
     */
    public static Param createParam(HttpServletRequest request) throws IOException {
        List<FormParam> formParamList = new ArrayList<>();
        formParamList.addAll(parseParameterNames(request));
        formParamList.addAll(parseInputStream(request));
        return new Param(formParamList);
    }

    /**
     * 解析请求参数
     */
    private static List<FormParam> parseParameterNames(HttpServletRequest request) {
        List<FormParam> formParamList = new ArrayList<>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String fieldName = paramNames.nextElement();
            String[] fieldValues = request.getParameterValues(fieldName);
            if (ArrayUtil.isNotEmpty(fieldValues)) {
                Object fieldValue;
                if (fieldValues.length == 1) {
                    fieldValue = fieldValues[0];
                } else {
                    StringBuilder builder = new StringBuilder("");
                    for (int i = 0; i < fieldValues.length; i++) {
                        builder.append(fieldValues[i]);
                        if (i != fieldValues.length - 1) {
                            builder.append(StringUtil.SEPARATOR);
                        }
                    }
                    fieldValue = builder.toString();
                }
                formParamList.add(new FormParam(fieldName, fieldValue));
            }
        }
        return formParamList;
    }

    /**
     * 获取请求参数，使用{@link HttpServletRequest#getInputStream()}
     */
    private static List<FormParam> parseInputStream(HttpServletRequest request) throws IOException {
        List<FormParam> formParamList = new ArrayList<>();
        String body = CodeUtils.decodeURL(StreamUtils.getString(request.getInputStream()));
        if (StringUtil.isNotEmpty(body)) {
            String[] kvs = StringUtil.splitString(body, "&");
            if (ArrayUtil.isNotEmpty(kvs)) {
                for (String kv : kvs) {
                    String[] array = StringUtil.splitString(kv, "=");
                    if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                        String fieldName = array[0];
                        String fieldValue = array[1];
                        formParamList.add(new FormParam(fieldName, fieldValue));
                    }
                }
            }
        }
        return formParamList;
    }
}
