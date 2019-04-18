package com.springboot.bookstore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.bookstore.bean.Order;
import com.springboot.bookstore.service.OrderService;

@Controller
public class OrderController {
	@Resource
	private OrderService orderService;
	
	@RequestMapping("/getOrders")
	public String findBooks(Model model) {
		List<Order> list =orderService.getOrders();
		model.addAttribute("list",list);
		return "order_list";
	}
	
	@RequestMapping("/pushOrder")
	public String pushOrder(Model model) {
		List<Order> list =orderService.getOrders();
		model.addAttribute("list",list);
		return "message_list";
	}
}
