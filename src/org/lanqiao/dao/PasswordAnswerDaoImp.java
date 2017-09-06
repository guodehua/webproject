package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.entity.Users;
import org.lanqiao.util.DBUtil;

public class PasswordAnswerDaoImp implements PasswordAnswerDao {

	@Override
	public void insertPasswordAnswer(PasswordAnswer passwordAnswer) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="insert into t_passwordanswer values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, passwordAnswer.getAnswerid());
			ps.setString(2, passwordAnswer.getAquestion());
			ps.setString(3, passwordAnswer.getAnswer());
			ps.setString(4, passwordAnswer.getAmail());
			ps.setString(5, passwordAnswer.getUserid());
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
	public PasswordAnswer getPasswordAnswerByUserid(String userid) {
		PasswordAnswer passwordAnswer = null;
		Connection conn = null;
		PreparedStatement ps = null;
		//System.out.println("uname"+uname);
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="select * from t_passwordanswer where userid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				passwordAnswer = new PasswordAnswer(rs.getString("answerid"), rs.getString("aquestion"), rs.getString("answer"), rs.getString("email"), rs.getString("userid"));
			}
			
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
		
		return passwordAnswer;
	}

	@Override
	public void upDate(PasswordAnswer passwordAnswer) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="update T_PASSWORDANSWER t SET t.AQUESTION = ?,t.ANSWER=?,t.EMAIL =? where t.USERID =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, passwordAnswer.getAquestion());
			ps.setString(2, passwordAnswer.getAnswer());
			ps.setString(3, passwordAnswer.getAmail());
			ps.setString(4, passwordAnswer.getUserid());
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
