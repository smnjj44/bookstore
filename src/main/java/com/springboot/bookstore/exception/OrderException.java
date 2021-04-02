package com.springboot.bookstore.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author simonliang
 * @className OrderException
 * @description
 * @date 2021/3/24 10:08 下午
 */
public class OrderException extends Exception{
    private static final Logger logger = LoggerFactory.getLogger(OrderException.class);

    public String message;

    public OrderException(String message) {
        this.message = message;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        logger.error("自定义异常信息:" + message);
    }
}
