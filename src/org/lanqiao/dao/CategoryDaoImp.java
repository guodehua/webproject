package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.News;
import org.lanqiao.util.DBUtil;

public class CategoryDaoImp implements CategoryDao {
	@Override
	public List<Category> list(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Category> list = new ArrayList<Category>();
		// 1.获取连接
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement("select * from t_category where corder < 14");
			rs = ps.executeQuery();
			Category cate = null;
			while (rs.next()) {
				cate = new Category(rs.getString("cid"), rs.getString("cname"));
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
	public Category get(String cid) {
		Category cate1 = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Category> list = new ArrayList<Category>();
		// 1.获取连接
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement("select * from t_category where cid = ?");
			ps.setString(1, cid);
			rs = ps.executeQuery();
			if (rs.next()) {
				cate1 = new Category(rs.getString("cid"), rs.getString("cname"));
				
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
		return cate1;
	}

}
