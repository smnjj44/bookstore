package com.springboot.bookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.bookstore.bean.Book;

@Mapper
public interface BookMapper {
	public List<Book> getAllBooks();
	
	public int addBook(Book book);
	
	public int delBook(String name);
	
	public List<Book> selBook(String name);
	
	public int updBook(Book book);
	
}
