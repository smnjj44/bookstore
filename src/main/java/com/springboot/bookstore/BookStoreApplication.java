package com.springboot.bookstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.springboot.bookstore.dao")//mapper和启动类不在同一目录下就要开启启动时对mapper的包扫描
public class BookStoreApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	@Override//为了打包springboot项目
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
}
