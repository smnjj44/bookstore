package com.springboot.bookstore.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.bookstore.service.LoginService;

@Controller
public class LoginController {
	@Resource
	private LoginService loginService;

	@RequestMapping("/login")
	public String login(String name, String password) {
		String pass = loginService.login(name);
		String[] arr = pass.split("_");
		if (arr.length != 0) {
			if (arr[0].equals(password)) {
				if(arr[1].equals("manager")) {
					return "manager_main";
				}
				if(arr[1].equals("customer")) {
					return "";
				}
			}
		}
		return "login_fail";
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
