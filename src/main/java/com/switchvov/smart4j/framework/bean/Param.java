package com.switchvov.smart4j.framework.bean;

import com.switchvov.smart4j.framework.utils.CastUtils;
import com.switchvov.smart4j.framework.utils.CollectionUtil;
import com.switchvov.smart4j.framework.utils.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求参数对象
 * Created by Switch on 2017/5/27.
 */
public class Param {

    private List<FormParam> formParamsList;
    private List<FileParam> fileParamList;

    public Param(List<FormParam> formParamsList) {
        this.formParamsList = formParamsList;
    }

    public Param(List<FormParam> formParamsList, List<FileParam> fileParamList) {
        this.formParamsList = formParamsList;
        this.fileParamList = fileParamList;
    }


    /**
     * 获取请求参数映射
     */
    public Map<String, Object> getFieldMap() {
        Map<String, Object> fieldMap = new HashMap<>();
        if (CollectionUtil.isNotEmpty(formParamsList)) {
            for (FormParam formParam : formParamsList) {
                String fieldName = formParam.getFieldName();
                Object fieldValue = formParam.getFieldValue();
                if (fieldMap.containsKey(fieldName)) {
                    fieldValue = fieldMap.get(fieldName) + StringUtil.SEPARATOR + fieldValue;
                }
                fieldMap.put(fieldName, fieldValue);
            }
        }
        return fieldMap;
    }

    /**
     * 获取上传文件映射
     */
    public Map<String, List<FileParam>> getFileMap() {
        Map<String, List<FileParam>> fileMap = new HashMap<>();
        if (CollectionUtil.isNotEmpty(fileParamList)) {
            for (FileParam fileParam : fileParamList) {
                String fieldName = fileParam.getFieldName();
                List<FileParam> fileParamList;
                if (fileMap.containsKey(fieldName)) {
                    fileParamList = fileMap.get(fieldName);
                } else {
                    fileParamList = new ArrayList<>();
                }
                fileParamList.add(fileParam);
                fileMap.put(fieldName, fileParamList);
            }
        }
        return fileMap;
    }

    /**
     * 获取所有上传文件
     */
    public List<FileParam> getFileList(String fieldName) {
        return getFileMap().get(fieldName);
    }

    /**
     * 获取唯一上传文件
     */
    public FileParam getFile(String fieldName) {
        List<FileParam> fileParamList = getFileList(fieldName);
        if (CollectionUtil.isNotEmpty(fileParamList) && fileParamList.size() == 1) {
            return fileParamList.get(0);
        }
        return null;
    }

    /**
     * 验证参数是否为空
     */
    public boolean isEmpty() {
        return CollectionUtil.isEmpty(formParamsList) && CollectionUtil.isEmpty(fileParamList);
    }

    /**
     * 根据参数名获取String型参数值
     */
    public String getString(String name) {
        return CastUtils.castString(getFieldMap().get(name));
    }

    /**
     * 根据参数名获取double型参数值
     */
    public double getDouble(String name) {
        return CastUtils.castDouble(getFieldMap().get(name));
    }

    /**
     * 根据参数名获取long型参数值
     */
    public long getLong(String name) {
        return CastUtils.castLong(getFieldMap().get(name));
    }

    /**
     * 根据参数名获取int型参数值
     */
    public int getInt(String name) {
        return CastUtils.castInt(getFieldMap().get(name));
    }

    /**
     * 根据参数名获取boolean型参数值
     */
    public boolean getBoolean(String name) {
        return CastUtils.castBoolean(getFieldMap().get(name));
    }
}