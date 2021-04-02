package com.springboot.bookstore.service.impl;

import com.springboot.bookstore.bean.Order;
import com.springboot.bookstore.exception.OrderException;

import java.util.List;

/**
 * @author simonliang
 * @className IOrderService
 * @description
 * @date 2021/3/25 12:15 上午
 */
public interface IOrderService {
    List<Order> getOrders() throws OrderException;

    int pushOrder(Order order);
}
