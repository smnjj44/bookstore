package com.springboot.bookstore.rabbitmq;

import com.springboot.bookstore.config.MqConfig;
import com.springboot.bookstore.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author simonliang
 * @className myProducer
 * @description
 * @date 2021/3/25 3:42 下午
 */
public abstract class MqProducer {
    @Autowired
    private MqConfig mqConfig;
    @Autowired
    private MqOperate mqOperate;

    public abstract ExChangeEnum exChange();

    public abstract ExChangeTypeEnum exChangeType();

    public abstract String getQueueName();

    RabbitTemplate rabbitTemplate = mqConfig.getRabbitTemplate();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public void sendMessage(Object object,String routingKey) {
        mqOperate.bindingExchange(exChangeType(),exChange(),getQueueName(),routingKey);
        rabbitTemplate.convertSendAndReceive(GsonUtil.toJson(object));
    }

}
