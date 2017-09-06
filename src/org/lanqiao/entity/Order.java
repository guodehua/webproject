package org.lanqiao.entity;

import java.util.Date;

public class Order {
	private String orderId;
	private String userId;
	private Integer totalPrice;
	private String orderDate;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderId, String userId, Integer totalPrice, String orderDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}
	public String getOrderId(){
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
}
