package com.zz.chapter05.utils;

import android.content.Context;
import android.os.Environment;
import android.text.format.Formatter;

import java.io.File;


/**
 Created by zz on 3/21/2018. */

public class FileUtils {

    // 缓存文件夹
    public static final String CACHE_DIR = "cache";
    // 图标文件夹
    public static final String ICON_DIR = "icon";
    // 下载文件夹
    public static final String DOWNLOAD_DIR = "download";
    // SD卡根目录下的文件夹
    public static final String APP_SD_ROOT_DIR = "Chapter05";

    public static String getCacheDir(Context context) {
        return getDir(context, CACHE_DIR);
    }

    private static String getDir(Context context, String name) {
        StringBuilder sb = new StringBuilder();
        if (isSDAvailable()) {
            sb.append(getAppExternalStoragePath());
        } else {
            sb.append(getCachePath(context));
        }
        sb.append(name);
        sb.append(File.separator);
        String path = sb.toString();
        if (createDirs(path)) {
            return path;
        } else {
            return null;
        }
    }

    /**
     创建文件夹
     @param path path
     @return boolean
     */
    private static boolean createDirs(String path) {
        File file = new File(path);
        return !(!file.exists() || !file.isDirectory()) || file.mkdirs();
    }

    /**
     返回本App的内部存储的Cache目录
     @param context context
     @return path
     */
    private static String getCachePath(Context context) {
        File f = context.getCacheDir();
        return f.getAbsolutePath() + File.separator;
    }

    /**
     返回本APP的SD卡根目录
     @return path
     */
    private static String getAppExternalStoragePath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator
                + APP_SD_ROOT_DIR
                + File.separator;
    }

    /**
     判断SD卡的状态
     @return available
     */
    private static boolean isSDAvailable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }


    /**
     检查SD卡是否可写
     @return writable
     */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /**
     检查SD卡是否可读
     @return readable
     */
    public static boolean isExternalStoryeReadable() {
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
    }

    /**
     检查SD卡的空间使用情况
     通过android.text.format.Formatter格式化容量
     @param context context
     @return string
     */
    public static String getSpaceInfo(Context context) {
        // 得到SD卡当前剩余空间
        long freeSpace = Environment.getExternalStorageDirectory().getFreeSpace();
        // 得到SD卡总空间
        long totalSpace = Environment.getExternalStorageDirectory().getTotalSpace();
        // 返回结果字符串
        return "SD卡空间： " + Formatter.formatFileSize(context, freeSpace) + " / " + Formatter.formatFileSize(context, totalSpace);
    }

    /**
     直接删除文件
     @param file file
     @return boolean
     */
    public static boolean deleteFileDirectly(File file) {
        return file.delete();
    }

    /**
     通过Context删除内部存储中的文件
     @param context context
     @param file    file
     @return boolean
     */
    public static boolean deleteFileByContext(Context context, String file) {
        return context.deleteFile(file);
    }
}
