package com.springboot.bookstore.service.impl;

import com.springboot.bookstore.bean.Notice;

import java.util.List;

/**
 * @author simonliang
 * @className INoticeService
 * @description
 * @date 2021/3/25 12:15 上午
 */
public interface INoticeService {
    List<Notice> getNotice();

    int addNotice(Notice notice);
}
