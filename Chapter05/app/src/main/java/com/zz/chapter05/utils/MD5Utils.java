package com.zz.chapter05.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 Created by zz on 3/20/2018. */

public class MD5Utils {
    /**
     对字符串进行MD5加密
     @param str str
     @return encodedString
     */
    public static String encodeString(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            // 把一个byte数组转换成加密后的byte数组
            byte[] bytes = digest.digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                int i = b & 0xFF; // 去掉负数，负数转换成正数
                String s = Integer.toHexString(i); // 转换成十六进制
                if(s.length() < 2){
                   sb.append("0"); // 让十六进制数都是二位的
                }
                sb.append(i);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
