package com.switchvov.smart4j.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 流操作工具类
 * Created by Switch on 2017/5/27.
 */
public final class StreamUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtils.class);

    /**
     * 从输入流中获取字符串
     */
    public static String getString(InputStream is) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (Exception e) {
            LOGGER.error("get string failure", e);
            throw new RuntimeException(e);
        }
        return builder.toString();
    }

    /**
     * 将输入流复制到输出流
     */
    public static void copyStream(InputStream inputStream, OutputStream outputStream) {
        try {
            int length;
            byte[] buffer = new byte[4 * 1024];
            while ((length = inputStream.read(buffer, 0, buffer.length)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
        } catch (Exception e) {
            LOGGER.error("copy stream failure", e);
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (Exception e) {
                LOGGER.error("close stream failure", e);
            }
        }
    }
}
