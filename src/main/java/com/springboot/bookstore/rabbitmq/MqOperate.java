package com.springboot.bookstore.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.stereotype.Component;

/**
 * @author simonliang
 * @className MqOperate
 * @description
 * @date 2021/3/30 10:05 上午
 */
@Component
public class MqOperate {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Queue setQueue(String getQueueName) {
        return new Queue(getQueueName);
    }

    private Exchange getExchange(ExChangeTypeEnum exChangeType, ExChangeEnum exChange) {
        if (exChangeType == ExChangeTypeEnum.FANOUT) {
            return new FanoutExchange(exChange.getExchangeName());
        }
        if (exChangeType == ExChangeTypeEnum.TOPIC) {
            return new TopicExchange(exChange.getExchangeName());
        }
        if (exChangeType == ExChangeTypeEnum.DIRECT) {
            return new DirectExchange(exChange.getExchangeName());
        }
        return null;
    }

    public Binding bindingExchange(ExChangeTypeEnum exChangeType, ExChangeEnum exChange, String getQueueName, String routingKey) {
        switch (exChangeType) {
            case FANOUT:
                return BindingBuilder.bind(setQueue(getQueueName)).to((FanoutExchange) getExchange(exChangeType,exChange));
            case TOPIC:
                if (routingKey == null) {
                    routingKey = "topic.#";
                }
                return BindingBuilder.bind(setQueue(getQueueName)).to((TopicExchange) getExchange(exChangeType,exChange)).with(routingKey);
            case DIRECT:
                if (routingKey == null) {
                    routingKey = "";
                }
                return BindingBuilder.bind(setQueue(getQueueName)).to((DirectExchange) getExchange(exChangeType,exChange)).with(routingKey);
            default:
                logger.info("没有匹配到对应类型");
                break;
        }
        return null;
    }
}
