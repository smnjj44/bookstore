package com.springboot.bookstore.service.impl;

import com.springboot.bookstore.bean.Book;

import java.util.List;

/**
 * @author simonliang
 * @className IBookService
 * @description
 * @date 2021/3/25 12:14 上午
 */
public interface IBookService {
    List<Book> findBooks();

    int addBook(Book book);

    int delBook(String name);

    List<Book> selBook(String name);

    int updBook(Book book);

    int updBookPath(Book book);
}
