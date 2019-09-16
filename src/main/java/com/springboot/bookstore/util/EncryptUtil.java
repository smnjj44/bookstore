package com.springboot.bookstore.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Security加密处理密码
 */
public class EncryptUtil {
    private static final String SECRET = "book";
    private static final PasswordEncoder encoder = new StandardPasswordEncoder(
            SECRET);

    /**
     * 加密
     * @param rawPassword
     * @return
     */
    public static String encrypt(String rawPassword) {
        return encryptBASE64(encoder.encode(rawPassword));
    }

    /**
     * 根据key判断密码正确不正确
     * @param rawPassword
     * @param password
     * @return
     */
    public static boolean match(String rawPassword, String password) {
        String key = decryptBASE64(password);
        return encoder.matches(rawPassword, key);
    }

    /**
     * base64加密
     *
     * @param key
     * @return
     */
    public static  String encryptBASE64(String key) {
        byte[] bt = key.getBytes();
        return (new BASE64Encoder()).encodeBuffer(bt);
    }

    /**
     * base64解密
     */
    public static String decryptBASE64(String key) {
        byte[] bt;
        try {
            bt = (new BASE64Decoder()).decodeBuffer(key);
            return new String(bt,"GBK");// 如果出现乱码可以改成： String(bt, "utf-8")或 gbk
        } catch (Exception e) {
            return "";
        }
    }
}
