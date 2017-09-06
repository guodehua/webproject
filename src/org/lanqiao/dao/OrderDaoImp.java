package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.Order;
import org.lanqiao.entity.OrderDetail;
import org.lanqiao.util.DBUtil;

public class OrderDaoImp implements OrderDao {

	@Override
	public void insertOrder(Order order) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="insert into t_order values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, order.getOrderId());
			ps.setString(2, order.getUserId());
			ps.setInt(3, order.getTotalPrice());
			ps.setString(4, order.getOrderDate());
			
			ps.executeUpdate();
			
		}catch(Exception e){
		}
		finally{
			//5关闭对象
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Order> getOrder() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Order> list = new ArrayList<Order>();
		// 1.获取连接
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement("select * from t_order");
			rs = ps.executeQuery();
			Order cate = null;
			while (rs.next()) {
				cate = new Order(rs.getString("orderId"), rs.getString("userId"), rs.getInt("totalPrice"), rs.getString("orderDate"));
				list.add(cate);
				// System.out.println(news.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list;
	}

	@Override
	public void insertOrderDetail(OrderDetail orderdetail) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="insert into t_orderdetail values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, orderdetail.getOrderDetailId());
			ps.setString(2, orderdetail.getGtitle());
			ps.setInt(3, orderdetail.getGsalprice());
			ps.setInt(4, orderdetail.getGnumber());
			ps.setString(5, orderdetail.getOrderid());
			
			ps.executeUpdate();
			
		}catch(Exception e){
		}
		finally{
			//5关闭对象
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<OrderDetail> getOrderDetail() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		// 1.获取连接
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement("select * from t_orderdetail");
			rs = ps.executeQuery();
			OrderDetail cate = null;
			while (rs.next()) {
				cate = new OrderDetail(rs.getString("orderDetailId"), rs.getString("gtitle"), rs.getInt("gsalprice"), rs.getInt("gnumber"), rs.getString("orderid"));
				list.add(cate);
				// System.out.println(news.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list;
	}

}
