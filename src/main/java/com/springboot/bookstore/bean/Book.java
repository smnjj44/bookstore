package com.springboot.bookstore.bean;

public class Book {
private int bid;
private String name;
private String author;
private String press;
private float price;
private float discount;
private String rdate;
private String type;
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPress() {
	return press;
}
public void setPress(String press) {
	this.press = press;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public float getDiscount() {
	return discount;
}
public void setDiscount(float discount) {
	this.discount = discount;
}
public String getRdate() {
	return rdate;
}
public void setRdate(String rdate) {
	this.rdate = rdate;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
}
