package com.springboot.bookstore.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.bookstore.service.LoginService;

@Controller
public class LoginController {
	@Resource
	private LoginService loginService;

	@RequestMapping("/login")
	public ModelAndView login(String name, String password) {
		String pass = loginService.login(name);
		String[] arr = pass.split("_");
		if (arr.length != 0) {
			if (arr[0].equals(password)) {
				if(arr[1].equals("manager")) {
					ModelAndView view = new ModelAndView("manager_main");
					view.addObject("name", arr[2]);
					return view;
				}
				if(arr[1].equals("customer")) {
					ModelAndView view = new ModelAndView("");
					view.addObject("name", arr[2]);
					return view;
				}
			}
		}
		ModelAndView view = new ModelAndView("login_fail");
		return view;
	}
	
	@RequestMapping("/register")
	public String register(String realname , String nickname , String password , String mailbox , String address) {
		if(loginService.register(realname, nickname, password, mailbox, address)) {
			return "index";
		}
		return "register_fail";
	}
	
	@RequestMapping("/forgetps")
	public String forgetPassword(String realname , String mailbox , String newpassword) {
	if(loginService.forgetPassword(realname, mailbox, newpassword)) {
		return "index";
	}
	return "";
	}
	
}
