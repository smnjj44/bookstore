package com.springboot.bookstore.rabbitmq;

import com.springboot.bookstore.config.MqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Predicate;

/**
 * @author simonliang
 * @className MqConsumer
 * @description
 * @date 2021/3/29 6:55 下午
 */
public abstract class MqConsumer {
    @Autowired
    private MqConfig mqConfig;
    @Autowired
    private MqOperate mqOperate;

    public abstract ExChangeEnum exChange();

    public abstract ExChangeTypeEnum exChangeType();

    public abstract String getQueueName();

    public abstract Predicate execute();

    RabbitTemplate rabbitTemplate = mqConfig.getRabbitTemplate();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    Queue queue = mqOperate.setQueue(getQueueName());

    @RabbitListener(queues = "#{queue.name}")
    public boolean consumer(String msg){
        logger.info("接收到消息:" + msg);
        return execute().test(msg);
    }
}
