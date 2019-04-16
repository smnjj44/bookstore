package com.springboot.bookstore.controller;

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
	public String findBooks(Model model) {
		List<Message> list =messageService.findMessage();
		model.addAttribute("list",list);
		return "message_list";
	}
}
