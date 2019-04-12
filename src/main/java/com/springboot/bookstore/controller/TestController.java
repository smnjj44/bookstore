package com.springboot.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
	@RequestMapping("/")
	public String index() {
		//Controller不能写返回的文字了，因为配置文件下配置了返回templates目录下的html文件，RestController才能写返回的文字
		return "manager_main";
	}
}
