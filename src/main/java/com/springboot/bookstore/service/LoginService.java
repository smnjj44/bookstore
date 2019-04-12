package com.springboot.bookstore.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.bookstore.bean.Manager;
import com.springboot.bookstore.dao.LoginMapper;

@Service
public class LoginService {
	@Resource
	private LoginMapper loginMapper;
	
	public String login(String name) {
		Manager manager =loginMapper.selectByName(name);
		return manager.getPassword();
	}
}
