package com.springboot.bookstore.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author simonliang
 * @className CollectionUtil
 * @description
 * @date 2021/3/24 4:54 下午
 */
public class CollectionUtil {
    /**
     * 可用
     * @param keyExecutor
     * @param map
     * @param <T>
     * @return
     */
    public static <T> Predicate<T> listDistinctByKey(Function<? super T,?> keyExecutor, ConcurrentHashMap map){
        return t -> map.putIfAbsent(t,Boolean.TRUE) == null;
    }
}
