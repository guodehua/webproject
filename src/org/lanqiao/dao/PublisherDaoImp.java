package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.Publisher;
import org.lanqiao.util.DBUtil;

public class PublisherDaoImp implements PublisherDao {

	@Override
	public List<Publisher> getPublisher() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Publisher> list = new ArrayList<Publisher>();
		// 1.获取连接
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement("select * from t_publisher");
			rs = ps.executeQuery();
			Publisher publisher = null;
			while (rs.next()) {
				publisher = new Publisher(rs.getString("pid"), rs.getString("pname"));
				list.add(publisher);
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
	public void insertPublisher(Publisher publisher) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="insert INTO T_PUBLISHER VALUES(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, publisher.getPid());
			ps.setString(2, publisher.getPname());
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
	public void deletePublisher(String pid) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="DELETE T_PUBLISHER WHERE PID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
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

}
