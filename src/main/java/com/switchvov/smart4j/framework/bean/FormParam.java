package com.switchvov.smart4j.framework.bean;

/**
 * 封装表单参数
 * Created by Switch on 2017/5/28.
 */
public class FormParam {
    private String fieldName;   // 表单字段名
    private Object fieldValue;  // 表单字段值

    public FormParam(String fieldName, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
