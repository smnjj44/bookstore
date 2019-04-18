package com.springboot.bookstore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.bookstore.bean.Notice;
import com.springboot.bookstore.bean.Order;
import com.springboot.bookstore.service.NoticeService;

@Controller
public class NoticeController {
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping("/addNotice")
	public String addNotice(String name,String content) {
		Notice notice = new Notice();
		notice.mangerName = name;
		notice.content = content;
		return "message_list";
	}
}
