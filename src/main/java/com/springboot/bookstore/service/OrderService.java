package com.springboot.bookstore.service;

import java.util.List;

import javax.annotation.Resource;

import com.springboot.bookstore.exception.OrderException;
import com.springboot.bookstore.service.impl.IOrderService;
import com.springboot.bookstore.util.CollectionUtil;
import org.springframework.stereotype.Service;

import com.springboot.bookstore.bean.Order;
import com.springboot.bookstore.dao.OrderMapper;
import org.springframework.util.CollectionUtils;

@Service
public class OrderService implements IOrderService {
	@Resource
	private OrderMapper orderMapper;

	@Override
	public List<Order> getOrders() throws OrderException {
		List<Order> list = orderMapper.selectOrders();
		if (CollectionUtils.isEmpty(list)){
			throw new OrderException("获取到订单为空");
		}
		return list;
	}

	@Override
	public int pushOrder(Order order) {
		orderMapper.pushOrder(order);
		return 0;
	}
}
