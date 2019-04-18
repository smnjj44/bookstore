package com.springboot.bookstore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/addBook")
	public ModelAndView addBook(String name,String author,String press ,String price,String discount,String rdate,String type) {
		Book book = new Book();
		book.setAuthor(author);
		book.setDiscount(Float.parseFloat(discount));
		book.setName(name);
		book.setPress(press);
		book.setPrice(Float.parseFloat(price));
		book.setRdate(rdate);
		book.setType(type);
		bookService.addBook(book);
		ModelAndView view = new ModelAndView("book_list");
		List<Book> list =bookService.findBooks();
		view.addObject("list", list);
		return view;
	}
	
	@RequestMapping("/delBook")
	public ModelAndView delBook(String name) {
		bookService.delBook(name);
		ModelAndView view = new ModelAndView("book_list");
		List<Book> list =bookService.findBooks();
		view.addObject("list", list);
		return view;
	}
	
	@RequestMapping("/selBook")
	public ModelAndView selBooks(String name) {
		List<Book> list =bookService.selBook(name);
		ModelAndView view = new ModelAndView("book_list");
		view.addObject("list", list);
		return view;
	}
	
	@RequestMapping("/updBook")
	public ModelAndView updBooks(String name,String author,String press ,float price,float discount,String rdate,String type) {
		Book book = new Book();
		book.setAuthor(author);
		book.setDiscount(discount);
		book.setName(name);
		book.setPress(press);
		book.setPrice(price);
		book.setRdate(rdate);
		book.setType(type);
		bookService.updBook(book);
		ModelAndView view = new ModelAndView("book_list");
		List<Book> list =bookService.findBooks();
		view.addObject("list", list);
		return view;
	}
	
	@RequestMapping("/customerAllBooks")
	public String customerAllBooks(Model model) {
		List<Book> list =bookService.findBooks();
		model.addAttribute("list",list);
		return "customer_book_list";
	}
}
