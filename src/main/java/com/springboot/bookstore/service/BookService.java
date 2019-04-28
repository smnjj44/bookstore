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
	
	public int addBook(Book book) {
		bookMapper.addBook(book);
		return 0;
	}
	
	public int delBook(String name) {
		bookMapper.delBook(name);
		return 0;
	}
	
	public List<Book> selBook(String name) {
		List<Book> book =bookMapper.selBook(name);
		return book;
	}
	
	public int updBook(Book book) {
		bookMapper.updBook(book);
		return 0;
	}
	
	public int updBookPath(Book book) {
		bookMapper.updBookPath(book);
		return 0;
	}
	
}
