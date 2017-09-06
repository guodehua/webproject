package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.News;
import org.lanqiao.util.DBUtil;

public class NewsDaoImp<T> implements NewsDao<T> {
	@Override
	public List<News> list() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		News news = null ;
		List<News> list =new ArrayList<News>();
		// 1.获取连接
		conn = DBUtil.getConnection();
		try {
		ps = conn.prepareStatement("select * from t_news");
		rs = ps.executeQuery();
		while(rs.next()){
			news = new News(rs.getString("tid"), rs.getString("title"), rs.getString("tcontent"), rs.getDate("tpubdate"));
			list.add(news);
			//System.out.println(news.toString());
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	public News getNews(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		News news = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_news where tid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				news = new News(rs.getString("tid"), rs.getString("title"), rs.getString("tcontent"), rs.getDate("tpubdate"));
			}
		} catch (Exception e) {
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
		return news;
	}
}
