package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Order;
import org.lanqiao.entity.OrderDetail;

public interface OrderService {
	public void insertOrder(Order order);
	public List<Order> getOrder();
	public void insertOrderDetail(OrderDetail orderdetail);
	public List<OrderDetail> getOrderDetail();
}
