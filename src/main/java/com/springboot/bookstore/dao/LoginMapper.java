package com.springboot.bookstore.dao;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.bookstore.bean.Manager;

@Mapper
public interface LoginMapper {
	public Manager selectByName(String name);
}
