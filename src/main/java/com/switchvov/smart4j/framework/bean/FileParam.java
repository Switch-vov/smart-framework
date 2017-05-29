package com.switchvov.smart4j.framework.bean;

import java.io.InputStream;

/**
 * 封装上传文件参数
 * Created by Switch on 2017/5/28.
 */
public class FileParam {
    private String fieldName;   // 文件表单字段名
    private String fileName;    // 文件名
    private long fileSize;      // 文件大小
    private String contentType; // 文件Content-Type
    private InputStream inputStream;// 文件字节输入流

    public FileParam(String fieldName, String fileName, long fileSize, String contentType, InputStream inputStream) {
        this.fieldName = fieldName;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.contentType = contentType;
        this.inputStream = inputStream;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getContentType() {
        return contentType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
