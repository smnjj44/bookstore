package com.springboot.bookstore.service.impl;

import com.springboot.bookstore.bean.Message;

import java.util.List;

/**
 * @author simonliang
 * @className IMessageService
 * @description
 * @date 2021/3/25 12:15 上午
 */
public interface IMessageService {
    List<Message> findMessage();

    int addMessage(Message message);
}
