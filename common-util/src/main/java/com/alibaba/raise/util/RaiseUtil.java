package com.alibaba.raise.util;

import com.alibaba.raise.constant.RaiseConstant;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;


/**
 * 项目通用工具方法类
 */
public class RaiseUtil {

    /**
     * 判断当前请求是否为ajax请求
     * @param request 请求对象
     * @return
     *      true：当前请求是ajax请求
     *      false：当前请求是普通请求
     */
    public static boolean judgeRequestType(HttpServletRequest request) {

        // 1.获取请求消息头
        String acceptHeader = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Requested-With");

        // 2.判断
        return (acceptHeader != null && acceptHeader.contains("application/json")) ||
                (xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
    }

    /**
     * 对明文字符串进行MD5加密
     * @param source 传入的明文字符串
     * @return 加密结果
     */
    public static String md5(String source) {

        // 判断source是否有效
        if(source == null || source.length() == 0) {
            // 如果不是有效的字符串抛出异常
            throw new RuntimeException(RaiseConstant.MESSAGE_STRING_INVALIDATE);
        }

        try {
            // 获取MessageDigest对象
            String algorithm = "md5";
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            // 获取明文字符串对应的字节数组
            byte[] input = source.getBytes();
            // 执行加密
            byte[] output = messageDigest.digest(input);
            // 创建BigInteger对象
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum, output);
            // 按照16进制将bigInteger的值转换为字符串
            int radix = 16;
            String encoded = bigInteger.toString(radix).toUpperCase();
            return encoded;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }






}
