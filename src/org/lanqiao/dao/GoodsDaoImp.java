package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Books;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.util.DBUtil;

public class GoodsDaoImp implements GoodsDao {
	//获取某一类别商品数据;
		@Override
		public PageInfo<Goods> list(String cid,int pagesize, int pageindex) {
			
			PageInfo<Goods> pageinfo = new PageInfo<Goods>();
			
			List<Goods> list = new ArrayList<Goods>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try{
				//1获取连接
				conn = DBUtil.getConnection();
				//2通过连接创建preparedstatement对象;
				String sql="select t2.* from (select t1.* ,rownum rn from (select * from t_goods where cid=?) t1 where rownum<=? ) t2 where rn>=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, cid);
				int endindex = pagesize * (pageindex+1);
				int startindex = (pageindex)*pagesize +1;
				ps.setInt(2, endindex);
				ps.setInt(3, startindex);
				//3执行操作
				rs = ps.executeQuery();
				//4取数据;
				Goods goods = null;
				while(rs.next()){
					goods = new Goods(rs.getString("gId"), rs.getString("gTitle"), rs.getString("gAuthor"), rs.getInt("gSaleprice"), rs.getInt("gSaleprice"), rs.getString("gDesc"), rs.getString("gImg"), rs.getInt("gClicks"), rs.getString("cId"), rs.getString("cId"));
					list.add(goods);
				}
				//给pageinfo对象赋值;
				pageinfo.setData(list);
				pageinfo.setIsfirstpage(pageindex==1);
				int totalnumber = this.totalRecords(cid);
				int totalpage = totalnumber % pagesize ==0 ? totalnumber / pagesize : totalnumber /pagesize +1;
				pageinfo.setIslastpage(totalpage==pageindex);
				pageinfo.setPageindex(pageindex);
				pageinfo.setPagesize(pagesize);
				pageinfo.setTotalnumber(totalnumber);
				pageinfo.setTotalpage(totalpage);
				
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
			return pageinfo;
		}
		//获取某一类别商口总数;
		@Override
		public int totalRecords(String cid) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			int total = 0;
			try{
				//1获取连接
				conn = DBUtil.getConnection();
				//2通过连接创建preparedstatement对象;
				String sql="select count(*) from t_goods where cid=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, cid);
				//3执行操作
				rs = ps.executeQuery();
				//4取数据;
				if(rs.next()){
					total = rs.getInt(1);
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
			return total;
		}
		//获得某一本书的详细信息
		@Override
		public Books getBookByCid(String cId){
			PageInfo<Goods> pageinfo = new PageInfo<Goods>();
			
			org.lanqiao.entity.Books book = null;
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			System.out.println("getcid"+cId);
			try{
				//1获取连接
				conn = DBUtil.getConnection();
				//2通过连接创建preparedstatement对象;
				String sql="select g.*,c.cname,p.pname from t_goods g,t_category c,t_publisher p where g.cid = c.cid and g.pid = p.pid and g.cid = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, cId);
				//3执行操作
				rs = ps.executeQuery();
				//4取数据;
				while(rs.next()){
					book = new Books(rs.getString("gId"), rs.getString("gTitle"),rs.getString("gAuthor"), rs.getInt("gSaleprice"), rs.getInt("gInprice"), rs.getString("gDesc"), rs.getString("gImg"), rs.getInt("gClicks"), rs.getString("cId"), rs.getString("cname"), rs.getString("pId"), rs.getString("pname"));
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
			return book;
		}
		@Override
		public Goods getBookByGid(String gId) {
			org.lanqiao.entity.Goods goods = null;
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			//System.out.println("getcid"+gId);
			try{
				//1获取连接
				conn = DBUtil.getConnection();
				//2通过连接创建preparedstatement对象;
				String sql="select * from t_goods where GID=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, gId);
				//3执行操作
				rs = ps.executeQuery();
				//4取数据;
				while(rs.next()){
					goods = new Goods(rs.getString("gId"), rs.getString("gTitle"), rs.getString("gAuthor"),rs.getInt("gSaleprice") ,rs.getInt("gInprice"), rs.getString("gDesc"), rs.getString("gImg"), rs.getInt("gClicks"), rs.getString("cId"), rs.getString("pId"));
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
			return goods;
		}
		@Override
		public Goods getBookByGtitle(String gtitle) {
			org.lanqiao.entity.Goods goods = null;
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try{
				//1获取连接
				conn = DBUtil.getConnection();
				//2通过连接创建preparedstatement对象;
				String sql="SELECT * FROM t_goods WHERE GTITLE LIKE ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+gtitle+"%");
				//3执行操作
				rs = ps.executeQuery();
				//4取数据;
				if(rs.next()){
					goods = new Goods(rs.getString("gId"), rs.getString("gTitle"), rs.getString("gAuthor"),rs.getInt("gSaleprice") ,rs.getInt("gInprice"), rs.getString("gDesc"), rs.getString("gImg"), rs.getInt("gClicks"), rs.getString("cId"), rs.getString("pId"));
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
					e.printStackTrace();
				}
			}
			return goods;
		}
		
		@Override
		public int updatePrice(Goods goods) {
			int ss = 0;
			Connection conn = null;
			PreparedStatement ps = null;
			try{
				//1获取连接
				conn = DBUtil.getConnection();
				//2通过连接创建preparedstatement对象;
				String sql="update t_goods set GSALEPRICE=?,GINPRICE=? where GID=?";
				try {
					//3执行操作
					ps = conn.prepareStatement(sql);
					ps.setInt(1, goods.getgSaleprice());
					ps.setInt(2, goods.getgInprice());
					ps.setString(3, goods.getgId());
					ss = ps.executeUpdate();
					//4取数据;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			finally{
				//5关闭对象
				try {
					if(ps!=null) ps.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return ss;
		}
		@Override
		public int deleteGoods(String gid) {
			int ss = 0;
			Connection conn = null;
			PreparedStatement ps = null;
			try{
				//1获取连接
				conn = DBUtil.getConnection();
				//2通过连接创建preparedstatement对象;
				String sql="DELETE FROM T_GOODS WHERE GID=?";
				try {
					//3执行操作
					ps = conn.prepareStatement(sql);
					ps.setString(1, gid);
					ss = ps.executeUpdate();
					//4取数据;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			finally{
				//5关闭对象
				try {
					if(ps!=null) ps.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return ss;
		}
}
