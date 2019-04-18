package com.springboot.bookstore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.bookstore.bean.Book;
import com.springboot.bookstore.bean.Order;
import com.springboot.bookstore.service.BookService;
import com.springboot.bookstore.service.LoginService;
import com.springboot.bookstore.service.OrderService;

@Controller
public class OrderController {
	@Resource
	private OrderService orderService;
	@Resource
	private BookService bookService;
	@Resource
	private LoginService loginService;
	
	@RequestMapping("/getOrders")
	public String findBooks(Model model) {
		List<Order> list =orderService.getOrders();
		model.addAttribute("list",list);
		return "order_list";
	}
	
	@RequestMapping("/pushOrder")
	public String pushOrder(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Order order = new Order();
		Map<Book , Integer> map = (Map<Book , Integer>)session.getAttribute("cartMap");
        if(map == null){
            map = new HashMap<Book , Integer>();
        }
        float money = 0;
        StringBuilder content = new StringBuilder();
        for(Book book : map.keySet()) {
        	money+=book.getPrice()*map.get(book);
        	content.append(book.getName()+"*"+map.get(book)) ;
        }
        
        order.cid=loginService.selectByCusName(request.getAttribute("customer_name").toString()).getCid();
        order.sumPrice = money;
        order.content = content.toString();
        orderService.pushOrder(order);
        return "push_success";
	}
	
	@RequestMapping("/addToCart")
	public String addToCart(HttpServletRequest request , String bookName) {
		 HttpSession session = request.getSession();
		List<Book> list = bookService.selBook(bookName);
		Book book = new Book();
		if(list!=null) {
		 book = list.get(0);
		}
		 @SuppressWarnings("unchecked")
		Map<Book , Integer> map = (Map<Book , Integer>)session.getAttribute("cartMap");
	        if(map == null){
	            map = new HashMap<Book , Integer>();
	        }
	        if(map.containsKey(book)) {
	        	map.put(book, map.get(book)+1);
	        }else {
	        	map.put(book, 1);
	        }
	        request.getSession().setAttribute("cartMap" , map);
	        return "cart_list";
	}
}
