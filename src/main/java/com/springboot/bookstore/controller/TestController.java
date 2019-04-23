package com.springboot.bookstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
	@RequestMapping("/")
	public String index() {
		//Controller不能写返回的文字了，因为配置文件下配置了返回templates目录下的html文件，RestController才能写返回的文字
		return "index";
	}
	
	@RequestMapping("/manager_repassword")
	public String repassword() {
		//Controller不能写返回的文字了，因为配置文件下配置了返回templates目录下的html文件，RestController才能写返回的文字
		return "manager_repassword";
	}
	
	@RequestMapping("/notice_add")
	public String noticeAdd() {
		//Controller不能写返回的文字了，因为配置文件下配置了返回templates目录下的html文件，RestController才能写返回的文字
		return "notice_add";
	}
	
	@RequestMapping("/customer_forgetps")
	public String cusforps() {
		//Controller不能写返回的文字了，因为配置文件下配置了返回templates目录下的html文件，RestController才能写返回的文字
		return "customer_forgetps";
	}
	
	@RequestMapping("/customer_register")
	public String cusregis() {
		//Controller不能写返回的文字了，因为配置文件下配置了返回templates目录下的html文件，RestController才能写返回的文字
		return "customer_register";
	}
	
	@RequestMapping("/book_update")
	public String bookUpdate() {
		//Controller不能写返回的文字了，因为配置文件下配置了返回templates目录下的html文件，RestController才能写返回的文字
		return "book_update";
	}
	
	@RequestMapping("/book_add")
	public String bookAdd() {
		//Controller不能写返回的文字了，因为配置文件下配置了返回templates目录下的html文件，RestController才能写返回的文字
		return "book_add";
	}
	
	@RequestMapping("/cart_list")
	public String cartList() {
		//Controller不能写返回的文字了，因为配置文件下配置了返回templates目录下的html文件，RestController才能写返回的文字
		return "cart_list";
	}
	
	@RequestMapping("/message_add")
	public String messageAdd() {
		//Controller不能写返回的文字了，因为配置文件下配置了返回templates目录下的html文件，RestController才能写返回的文字
		return "message_add";
	}
}
