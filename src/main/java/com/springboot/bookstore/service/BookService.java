package com.springboot.bookstore.service;

import java.util.List;

import javax.annotation.Resource;

import com.springboot.bookstore.service.impl.IBookService;
import org.springframework.stereotype.Service;

import com.springboot.bookstore.bean.Book;
import com.springboot.bookstore.dao.BookMapper;

@Service
public class BookService implements IBookService {
	@Resource
	private BookMapper bookMapper;

	@Override
	public List<Book> findBooks() {
		List<Book> list = bookMapper.getAllBooks();
		return list;
	}

	@Override
	public int addBook(Book book) {
		bookMapper.addBook(book);
		return 0;
	}

	@Override
	public int delBook(String name) {
		bookMapper.delBook(name);
		return 0;
	}

	@Override
	public List<Book> selBook(String name) {
		List<Book> book =bookMapper.selBook(name);
		return book;
	}

	@Override
	public int updBook(Book book) {
		bookMapper.updBook(book);
		return 0;
	}

	@Override
	public int updBookPath(Book book) {
		bookMapper.updBookPath(book);
		return 0;
	}
	
}
