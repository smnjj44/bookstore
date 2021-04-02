package com.springboot.bookstore.service;

import java.util.List;

import javax.annotation.Resource;

import com.springboot.bookstore.service.impl.INoticeService;
import org.springframework.stereotype.Service;

import com.springboot.bookstore.bean.Notice;
import com.springboot.bookstore.bean.Order;
import com.springboot.bookstore.dao.NoticeMapper;

@Service
public class NoticeService implements INoticeService {
	@Resource
	private NoticeMapper noticeMapper;

	@Override
	public List<Notice> getNotice(){ 
		List<Notice> list = noticeMapper.getAllNotice();
		return list;
	}

	@Override
	public int addNotice(Notice notice) {
		noticeMapper.addNotice(notice);
		return 0 ;
	}
}
