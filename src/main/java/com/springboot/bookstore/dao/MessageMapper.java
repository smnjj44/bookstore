package com.springboot.bookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.bookstore.bean.Message;

@Mapper
public interface MessageMapper {
	public List<Message> getAllMessage();
}
