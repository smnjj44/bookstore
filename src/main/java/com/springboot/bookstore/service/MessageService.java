package com.springboot.bookstore.service;

import java.util.List;

import javax.annotation.Resource;

import com.springboot.bookstore.service.impl.IMessageService;
import org.springframework.stereotype.Service;

import com.springboot.bookstore.bean.Message;
import com.springboot.bookstore.dao.MessageMapper;



@Service
public class MessageService implements IMessageService {
	@Resource
	private MessageMapper messageMapper;

	@Override
	public List<Message> findMessage(){
		List<Message> list = messageMapper.getAllMessage();
		return list;
	}

	@Override
	public int addMessage(Message message){
		messageMapper.addMessage(message);
		return 0;
	}
}
