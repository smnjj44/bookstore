package com.springboot.bookstore.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.bookstore.bean.Message;
import com.springboot.bookstore.service.MessageService;

@Controller
public class MessageController {
	@Resource
	private MessageService messageService;
	
	@RequestMapping("/allMessage")
	public String findMessage(Model model) {
		List<Message> list =messageService.findMessage();
		model.addAttribute("list",list);
		return "message_list";
	}
	
	@RequestMapping("/addMessage")
	public String addMessage(int id , String content) {
		Message message = new Message();
		message.cid= id;
		message.content = content;
		message.date = String.valueOf(new Date());
		messageService.addMessage(message);
		return "customer_message_list";
	}
	
	@RequestMapping("/getMessage")
	public String getMessage(Model model) {
		List<Message> list =messageService.findMessage();
		model.addAttribute("list",list);
		return "customer_message_list";
	}
}
