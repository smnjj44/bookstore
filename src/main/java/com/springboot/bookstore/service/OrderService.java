package com.springboot.bookstore.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.bookstore.bean.Order;
import com.springboot.bookstore.dao.OrderMapper;

@Service
public class OrderService {
	@Resource
	private OrderMapper orderMapper;
	
	public List<Order> getOrders(){
		List<Order> list = orderMapper.selectOrders();
		return list;
	}
}
