package com.springboot.bookstore.rabbitmq;

/**
 * @author simonliang
 * @className ExChangeEnum
 * @description
 * @date 2021/3/25 3:44 下午
 */
public enum ExChangeEnum {

    EXCHANGE_BOOKSTORE("BOOKSTORE",false),
    EXCHANGE_BOOKSTORE_DELAY("BOOKSTORE_DELAY",true);

    private String exchangeName;
    private boolean isDelay;

    ExChangeEnum(String exchangeName, boolean isDelay) {
        this.exchangeName = exchangeName;
        this.isDelay = isDelay;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public boolean isDelay() {
        return isDelay;
    }
}
