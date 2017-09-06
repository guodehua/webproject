package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.entity.Users;
import org.lanqiao.util.DBUtil;

public class UserDaoImp implements UserDao {
	//添加用户
	@Override
	public void regi(Users user) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="insert into t_user values(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUemail());
			ps.setString(3, user.getUname());
			ps.setString(4, user.getUpassword());
			ps.setString(5, user.getUsex());
			ps.setString(6, user.getUaddress());
			ps.setString(7, user.getUtel());
			ps.setString(8, user.getUstateid());
			ps.setString(9, user.getUroleid());
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
	public Users getUserByName(String uname) {
		Users user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		//System.out.println("uname"+uname);
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="select * from t_user where uname = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new Users(rs.getString("userid"), rs.getString("uemail"), rs.getString("uname"), rs.getString("upassword"), rs.getString("usex"), rs.getString("uaddress"), rs.getString("utel"), rs.getString("ustateid"), rs.getString("uroleid"));
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
		return user;
	}
	//邮箱验证插入ustateid
	@Override
	public void insertUstateid(String userid, String ustateid) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="insert t_user set ustateid=? where userid= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ustateid);
			ps.setString(2, userid);
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
	public void insertUsersAgain(Users user) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="update T_USER t SET t.UPASSWORD = ?,t.USEX=?,t.UADDRESS=?,t.UTEL=? where t.USERID =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUpassword());
			ps.setString(2, user.getUsex());
			ps.setString(3, user.getUaddress());
			ps.setString(4, user.getUtel());
			ps.setString(5, user.getUserid());
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
	public List<Users> userList() {
		List<Users> ulist = new ArrayList<Users>();
		Users user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="select * from t_user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new Users(rs.getString("userid"), rs.getString("uemail"), rs.getString("uname"), rs.getString("upassword"), rs.getString("usex"), rs.getString("uaddress"), rs.getString("utel"), rs.getString("ustateid"), rs.getString("uroleid"));
				ulist.add(user);
			}
			
		}catch(Exception e){
		}
		finally{
			//5关闭对象
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ulist;
	}

	@Override
	public boolean removeUserByUserid(String userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		int in=0;//判断书否删除成功
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="DELETE FROM T_USER WHERE userid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			in = ps.executeUpdate();
			
			
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
		if (in==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Users getUserByEmail(String uemail) {
		Users user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		//System.out.println("uname"+uname);
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="select * from t_user where uemail = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uemail);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new Users(rs.getString("userid"), rs.getString("uemail"), rs.getString("uname"), rs.getString("upassword"), rs.getString("usex"), rs.getString("uaddress"), rs.getString("utel"), rs.getString("ustateid"), rs.getString("uroleid"));
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
		return user;
	}

}
