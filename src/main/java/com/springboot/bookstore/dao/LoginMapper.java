package com.springboot.bookstore.dao;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.bookstore.bean.Customer;
import com.springboot.bookstore.bean.Manager;

import java.util.List;

@Mapper
public interface LoginMapper {
	public Manager selectByManName(String name);
	
	public Customer selectByCusName(String name);
	
	public int insertCustomer(Customer customer); 
	
	public int updateCustomerPassword(Customer customer);
	
	public int updateManagerPassword(Manager manager);

	public List<Manager> selectsByManName(String name);

	public List<Customer> selectsByCusName(String name);

	public String getAuthByManName(String name);

	public String getAuthByCusName(String realname);
}
