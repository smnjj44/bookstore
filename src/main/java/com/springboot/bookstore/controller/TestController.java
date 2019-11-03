package com.springboot.bookstore.controller;


import com.springboot.bookstore.bean.Customer;
import com.springboot.bookstore.service.LoginService;
import com.springboot.bookstore.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class TestController {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Resource
	private LoginService loginService;

	@RequestMapping("/")
	public ModelAndView index(HttpSession httpSession,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				String value = cookies[i].getValue();
				if (value != null) {
					String userName = jwtTokenUtil.getUserNameFromToken(value);
					String manName = loginService.getAuthByManName(userName);
					String cusName = loginService.getAuthByCusName(userName);
					if (manName != null) {
						ModelAndView view = new ModelAndView("manager_main");
						httpSession.setAttribute("token", value);
						httpSession.setAttribute("manager_name", userName);
						view.addObject("name", userName);
						return view;
					}
					if (cusName != null) {
						ModelAndView view = new ModelAndView("customer_main");
						httpSession.setAttribute("token", value);
						view.addObject("name", userName);
						Customer cus = loginService.selectByCusName(userName);
						httpSession.setAttribute("customer_cid", cus.getCid());
						httpSession.setAttribute("customer_name", userName);
						return view;
					}
				}
			}
		}
		//Controller不能写返回的文字了，因为配置文件下配置了返回templates目录下的html文件，RestController才能写返回的文字
		ModelAndView view = new ModelAndView("index");
		return view;
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
	
	@RequestMapping("/customer_repassword")
	public String customerRepassword() {
		//Controller不能写返回的文字了，因为配置文件下配置了返回templates目录下的html文件，RestController才能写返回的文字
		return "customer_repassword";
	}
}
