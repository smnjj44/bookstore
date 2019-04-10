package com.springboot.bookstore.dao;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.bookstore.bean.Test;


@Mapper
public interface TestMapper {
	public void insert(Test test);
}
