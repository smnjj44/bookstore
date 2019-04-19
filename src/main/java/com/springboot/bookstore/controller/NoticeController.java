package com.springboot.bookstore.controller;

import java.util.Date;
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
	public String addNotice(String managerName,String content) {
		Notice notice = new Notice();
		notice.managerName = managerName;
		notice.content = content;
		notice.createDate = new Date().toString();
		noticeService.addNotice(notice);
		return "notice_add_success";
	}
	
	@RequestMapping("/getNotices")
	public String getNotices(Model model) {
		List<Notice> list =noticeService.getNotice();
		model.addAttribute("list",list);
		return "notice_list";
	}
}
