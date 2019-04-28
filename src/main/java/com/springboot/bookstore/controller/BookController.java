package com.springboot.bookstore.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.FileInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.bookstore.bean.Book;
import com.springboot.bookstore.service.BookService;

@Controller
public class BookController {

	@Resource
	private BookService bookService;

	@RequestMapping("/allBooks")
	public String findBooks(Model model) {
		List<Book> list = bookService.findBooks();
		model.addAttribute("list", list);
		return "book_list";
	}

	@RequestMapping("/addBook")
	public ModelAndView addBook(String name, String author, String press, String price, String discount, String rdate,
			String type) {
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
		List<Book> list = bookService.findBooks();
		view.addObject("list", list);
		return view;
	}

	@RequestMapping("/delBook")
	public ModelAndView delBook(String name) {
		bookService.delBook(name);
		ModelAndView view = new ModelAndView("book_list");
		List<Book> list = bookService.findBooks();
		view.addObject("list", list);
		return view;
	}

	@RequestMapping("/selBook")
	public ModelAndView selBooks(String name) {
		List<Book> list = bookService.selBook(name);
		ModelAndView view = new ModelAndView("book_list");
		view.addObject("list", list);
		return view;
	}

	@RequestMapping("/updBook")
	public ModelAndView updBooks(String name, String author, String press, float price, float discount, String rdate,
			String type) {
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
		List<Book> list = bookService.findBooks();
		view.addObject("list", list);
		return view;
	}

	@RequestMapping("/customerAllBooks")
	public String customerAllBooks(Model model) {
		List<Book> list = bookService.findBooks();
		model.addAttribute("list", list);
		return "customer_book_list";
	}

	@RequestMapping("/customerSelBook")
	public ModelAndView customerSelBooks(String name) {
		List<Book> list = bookService.selBook(name);
		ModelAndView view = new ModelAndView("customer_book_list");
		view.addObject("list", list);
		return view;
	}

	@RequestMapping("/upload")
	public ModelAndView upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String name = request.getParameter("name");
		ModelAndView view = new ModelAndView("upload_fail");
		if (!file.isEmpty()) {
			String saveFileName = file.getOriginalFilename();
			File saveFile = null;
			try {
				saveFile = new File(ResourceUtils.getURL("classpath:static").getPath() + "/" + saveFileName);
				System.out.println();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("保存路径为：" + saveFile);
			// String path = saveFile.toString().replace("\\","/");
			List<Book> books = bookService.selBook(name);
			Book book = new Book();
			if (books != null && books.size() > 0) {
				book = books.get(0);
				book.setPath(saveFileName);
				bookService.updBookPath(book);
			}
//	            if (!saveFile.getParentFile().exists()) {
//	                saveFile.getParentFile().mkdirs();
//	            }
			try {
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
				out.write(file.getBytes());
				out.flush();
				out.close();
				List<Book> list = bookService.findBooks();
				ModelAndView view2 = new ModelAndView("book_list");
				view2.addObject("list", list);
				return view2;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				return view;
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				return view;
			}
		} else {
			return view;
		}
	}

}
