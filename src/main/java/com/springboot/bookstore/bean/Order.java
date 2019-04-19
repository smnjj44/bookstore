package com.springboot.bookstore.bean;



/**
 * 订单
 * @author SimonLiang
 *
 */
public class Order {
private int oid;
private float sumPrice;
private String content;
//订单顾客id
private int cid;
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public float getSumPrice() {
	return sumPrice;
}
public void setSumPrice(float sumPrice) {
	this.sumPrice = sumPrice;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
}
