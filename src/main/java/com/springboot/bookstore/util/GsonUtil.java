package com.springboot.bookstore.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

/**
 * @author simonliang
 * @className GsonUtil
 * @description
 * @date 2021/3/25 10:41 下午
 */
public class GsonUtil {
    public static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> c) {
        return gson.fromJson(json, c);
    }
    public static <T> T fromJson(JsonElement jsonElement, Class<T> c) {
        return gson.fromJson(jsonElement, c);
    }

}
