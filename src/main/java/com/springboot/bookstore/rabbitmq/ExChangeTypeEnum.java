package com.springboot.bookstore.rabbitmq;

/**
 * @author simonliang
 * @className ExChangeTypeEnum
 * @description
 * @date 2021/3/25 4:04 下午
 */
public enum ExChangeTypeEnum {
    TOPIC("topic"),
    FANOUT("fanout"),
    DIRECT("direct")
    ;
    String name;

    ExChangeTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
