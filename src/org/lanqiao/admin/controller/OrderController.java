package org.lanqiao.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Order;
import org.lanqiao.entity.OrderDetail;

import com.google.gson.Gson;

/**
 * Servlet implementation class OrderController
 */
@WebServlet(name = "orderController", urlPatterns = { "/orderController.do" })
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		org.lanqiao.service.OrderService os = new org.lanqiao.service.OrderServiceImp();
		//List<Order> list = os.getOrder();
		List<OrderDetail> orderDetails = os.getOrderDetail();
		Gson gson = new Gson();
		//response.getWriter().write(gson.toJson(list));
		response.getWriter().write(gson.toJson(orderDetails));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
