package com.springboot.bookstore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.springboot.bookstore.exception.OrderException;
import com.springboot.bookstore.service.impl.IBookService;
import com.springboot.bookstore.service.impl.ILoginService;
import com.springboot.bookstore.service.impl.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.bookstore.bean.Book;
import com.springboot.bookstore.bean.Customer;
import com.springboot.bookstore.bean.Order;

@Controller
public class OrderController {
	@Resource
	private IOrderService orderService;
	@Resource
	private IBookService bookService;
	@Resource
	private ILoginService loginService;

	@RequestMapping("/getOrders")
	public String findBooks(Model model) {
		List<Order> list = null;
		try {
			list = orderService.getOrders();
		} catch (OrderException e) {
			e.printStackTrace();
		}
		model.addAttribute("list", list);
		return "order_list";
	}

	@RequestMapping("/pushOrder")
	public String pushOrder(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Order order = new Order();
		Map<Book, Integer> map = (Map<Book, Integer>) session.getAttribute("cartMap");
		if (map == null) {
			map = new HashMap<Book, Integer>();
		}
		float money = 0;
		StringBuilder content = new StringBuilder();
		for (Book book : map.keySet()) {
			money += book.getPrice() * map.get(book);
			content.append(book.getName() + "*" + map.get(book)+"；");
			Customer customer = new Customer();
			customer.setCid(loginService.selectByCusName(session.getAttribute("customer_name").toString()).getCid());
			order.setCid(customer.getCid());
			order.setSumPrice(money);
			order.setContent(content.toString());
		}
		orderService.pushOrder(order);
		session.removeAttribute("cartMap");
		session.removeAttribute("map2");
		return "push_success";
	}

	@RequestMapping("/addToCart")
	public String addToCart(HttpServletRequest request, String bookName) {
		HttpSession session = request.getSession();
		List<Book> list = bookService.selBook(bookName);
		Book book = new Book();
		if (list != null) {
			book = list.get(0);
		}
		@SuppressWarnings("unchecked")
		Map<String, Integer> map2 = (Map<String, Integer>) session.getAttribute("map2");
		if (map2 == null) {
			map2 = new HashMap<String, Integer>();
		}
		if (map2.containsKey(book.getName())) {
			map2.put(book.getName(), map2.get(book.getName()) + 1);
		} else {
			map2.put(book.getName(), 1);
		}
		request.getSession().setAttribute("map2", map2);
		Map<Book, Integer> map = new HashMap<Book, Integer>();
		for (String name : map2.keySet()) {
			map.put(bookService.selBook(name).get(0), map2.get(name));
		}
		request.getSession().setAttribute("cartMap", map);
		return "cart_list";
	}
}
