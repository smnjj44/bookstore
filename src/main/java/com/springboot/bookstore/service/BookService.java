package com.springboot.bookstore.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.bookstore.bean.Book;
import com.springboot.bookstore.dao.BookMapper;

@Service
public class BookService {
	@Resource
	private BookMapper bookMapper;
	
	public List<Book> findBooks() {
		List<Book> list = bookMapper.getAllBooks();
		return list;
	}
}
