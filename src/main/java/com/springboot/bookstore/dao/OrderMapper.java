package com.springboot.bookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.bookstore.bean.Order;

@Mapper
public interface OrderMapper {
public List<Order> selectOrders();

public int pushOrder(Order order);
}
