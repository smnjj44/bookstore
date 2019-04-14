package com.springboot.bookstore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.bookstore.bean.Book;
import com.springboot.bookstore.service.BookService;

@Controller
public class BookController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("/allBooks")
	public String findBooks(Model model) {
		List<Book> list =bookService.findBooks();
		model.addAttribute("list",list);
		return "book_list";
	}
}
