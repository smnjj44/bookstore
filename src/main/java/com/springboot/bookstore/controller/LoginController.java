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
	public String login(String name,String password) {
		String pass = loginService.login(name);
		if(password.equals(pass)) {
			return "login_success";
		}
		return "login_fail";
	}
}
