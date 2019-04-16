package com.springboot.bookstore.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.bookstore.bean.Message;
import com.springboot.bookstore.dao.MessageMapper;



@Service
public class MessageService {
	@Resource
	private MessageMapper messageMapper;
	
	public List<Message> findMessage(){
		List<Message> list = messageMapper.getAllMessage();
		return list;
	}
}
