package com.springboot.bookstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.bookstore.bean.Customer;
import com.springboot.bookstore.bean.Manager;
import com.springboot.bookstore.dao.LoginMapper;

@Service
public class LoginService {
	@Resource
	private LoginMapper loginMapper;
	
	public String login(String name) {
		Manager manager =loginMapper.selectByManName(name);
		Customer customer = loginMapper.selectByCusName(name);
		Map<String,String> map = new HashMap<String,String>();
		if(manager != null) {
			map.put("author", manager.getName());
			return manager.getPassword()+"_manager"; 
		}
		if(customer != null) {
			map.put("author", customer.getRealname());
			return customer.getPassword()+"_customer";
		}
		return null;
	}
	
	public boolean register(String realname , String nickname , String password , String mailbox , String address) {
		Manager manager =loginMapper.selectByManName(realname);
		Customer customer = loginMapper.selectByCusName(nickname);
		if(manager != null) {
			return false; 
		}
		if(customer != null) {
			return false;
		}
		Customer cus = new Customer();
		cus.setRealname(realname);
		cus.setNickname(nickname);
		cus.setPassword(password);
		cus.setMailbox(mailbox);
		cus.setAddress(address);
		loginMapper.insertCustomer(cus);
		return true;
	}
	
	public boolean forgetPassword(String realname , String mailbox , String password) {
		Customer customer = loginMapper.selectByCusName(realname);
		if(customer.getMailbox().equals(mailbox)) {
			customer.setPassword(password);
			loginMapper.updateCustomerPassword(customer);
			return true;
		}
		return false;
	}
}
