package com.springboot.bookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.bookstore.bean.Book;

@Mapper
public interface BookMapper {
	public List<Book> getAllBooks();
}
