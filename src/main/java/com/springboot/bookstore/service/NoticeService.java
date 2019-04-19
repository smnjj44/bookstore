package com.springboot.bookstore.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.bookstore.bean.Notice;
import com.springboot.bookstore.bean.Order;
import com.springboot.bookstore.dao.NoticeMapper;

@Service
public class NoticeService {
	@Resource
	private NoticeMapper noticeMapper;
	
	public List<Notice> getNotice(){ 
		List<Notice> list = noticeMapper.getAllNotice();
		return list;
	}
	
	public int addNotice(Notice notice) {
		noticeMapper.addNotice(notice);
		return 0 ;
	}
}
