package org.lanqiao.service;

import java.util.List;

import org.apache.tomcat.jni.OS;
import org.lanqiao.entity.Order;
import org.lanqiao.entity.OrderDetail;

public class OrderServiceImp implements OrderService {
	org.lanqiao.dao.OrderDao os = new org.lanqiao.dao.OrderDaoImp();
	@Override
	public void insertOrder(Order order) {
		os.insertOrder(order);
	}
	@Override
	public List<Order> getOrder() {
		return os.getOrder();
	}
	@Override
	public void insertOrderDetail(OrderDetail orderdetail) {
		os.insertOrderDetail(orderdetail);
		
	}
	@Override
	public List<OrderDetail> getOrderDetail() {
		return os.getOrderDetail();
	}

}
