package com.springboot.bookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.bookstore.bean.Notice;

@Mapper
public interface NoticeMapper {
public List<Notice> getAllNotice();
public int addNotice(Notice notice);
}
