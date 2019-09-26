package com.springboot.bookstore.service;


import javax.annotation.Resource;

import com.springboot.bookstore.util.EncryptUtil;
import com.springboot.bookstore.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.springboot.bookstore.bean.Customer;
import com.springboot.bookstore.bean.Manager;
import com.springboot.bookstore.dao.LoginMapper;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginService {
	@Resource
	private LoginMapper loginMapper;
	@Autowired
	private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
	
	public String login(String name) {
		Manager manager =loginMapper.selectByManName(name);
		Customer customer = loginMapper.selectByCusName(name);
		if(manager != null) {
			return manager.getPassword()+"_manager"+"_"+manager.getName(); 
		}
		if(customer != null) {
			return customer.getPassword()+"_customer"+"_"+customer.getRealname();
		}
		return null;
	}
	
	public boolean register(String realname , String nickname , String password , String mailbox , String address) {
		Manager manager =loginMapper.selectByManName(realname);
		Customer customer = loginMapper.selectByCusName(realname);
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
	
	public int rePassword(String name , String oldPasswd , String newPasswd, String reNewPasswd) {
		Manager manager = new Manager();
		manager = loginMapper.selectByManName(name);
		if(manager.getPassword().equals(oldPasswd)) {
			if(newPasswd.equals(reNewPasswd)) {
				manager.setPassword(newPasswd);
				loginMapper.updateManagerPassword(manager);
				return 0;
			}
		}
		return 1;
	}
	
	public Customer selectByCusName(String name) {
		Customer customer = loginMapper.selectByCusName(name);
		return customer;
	}
	
	public int cusRepassword(String name , String oldPasswd , String newPasswd, String reNewPasswd) {
		Customer customer = new Customer();
		customer = loginMapper.selectByCusName(name);
		if(customer.getPassword().equals(oldPasswd)) {
			if(newPasswd.equals(reNewPasswd)) {
				customer.setPassword(newPasswd);
				loginMapper.updateCustomerPassword(customer);
				return 0;
			}
		}
		return 1;
	}

	public boolean securityRegister(String realname , String nickname , String password , String mailbox , String address) {
		List<Manager> managerList =loginMapper.selectsByManName(realname);
		List<Customer> customerList = loginMapper.selectsByCusName(realname);
		if(managerList.size() > 0) {
			return false;
		}
		if(customerList.size() > 0) {
			return false;
		}
		Customer cus = new Customer();
		cus.setRealname(realname);
		cus.setNickname(nickname);
		cus.setPassword(EncryptUtil.encrypt(password));
		cus.setMailbox(mailbox);
		cus.setAddress(address);
		loginMapper.insertCustomer(cus);
		return true;
	}

	public Map<String,Object> securityLogin(String name, String password) {
        String token = null;
        HashMap map = new HashMap<String,String>();
	    try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(name);
            if (!EncryptUtil.match(password,userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            map.put("token",token);
            map.put("ath", userDetails.getAuthorities());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  map;
	}
}
