package com.springboot.bookstore.dao;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.bookstore.bean.Customer;
import com.springboot.bookstore.bean.Manager;

@Mapper
public interface LoginMapper {
	public Manager selectByManName(String name);
	
	public Customer selectByCusName(String name);
	
	public int insertCustomer(Customer customer); 
	
	public int updateCustomerPassword(Customer customer);
	
	public int updateManagerPassword(Manager manager);
}
