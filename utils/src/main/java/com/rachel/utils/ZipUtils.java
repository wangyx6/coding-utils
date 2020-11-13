package com.rachel.utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * java中处理压缩文件的工具方法
 * @author wangyx
 * @see ZipUtils
 * @since 2020/11/13
 */
public class ZipUtils {

    public static void zip(String inputFilePath, String outputFilePath) throws IOException {
        long beginTime = System.currentTimeMillis();
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outputFilePath));
        for(File zipFile : new File(inputFilePath).listFiles()){
            FileInputStream inputStream = new FileInputStream(zipFile);
            out.putNextEntry(new ZipEntry(zipFile.getName()));
            int temp = 0;
            byte[] bytes = new byte[2048];
            while((temp = inputStream.read(bytes)) != -1){
                out.write(bytes);
            }
        }
        System.out.println("压缩共花费：" + (System.currentTimeMillis()  - beginTime));
    }

    public static void main(String[] args) throws IOException {
        ZipUtils.zip("D:\\temp\\123","D:\\temp\\123123.zip");
    }
}
