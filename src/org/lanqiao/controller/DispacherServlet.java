package org.lanqiao.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.entity.Books;
import org.lanqiao.entity.Carts;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.News;
import org.lanqiao.entity.Order;
import org.lanqiao.entity.OrderDetail;
import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.entity.SessionCart;
import org.lanqiao.entity.Users;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet(name = "dispacher", urlPatterns = { "/dispacher.do" })
public class DispacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String cId = request.getParameter("cId");
		if(type!=null && type.equals("news") && id!=null){
			//根据ID取新闻的信息
			org.lanqiao.service.NewsService ns = new org.lanqiao.service.NewsServiceImp();
			News news = ns.getNewsById(id);
			request.setAttribute("news", news);
			request.getRequestDispatcher("/WEB-INF/title.jsp").forward(request, response);
		}else if(type!=null && type.equals("books") && cId!=null){
			org.lanqiao.service.GoodsService gs = new org.lanqiao.service.GoodsServiceImp();
			Books books = gs.getBookByCid(cId);
			request.setAttribute("books", books);
			request.getRequestDispatcher("/WEB-INF/info.jsp").forward(request, response);
		}else if(type!=null && type.equals("cart")){  //购物车 
			Gson gson = new Gson();
			List<Carts> cookieList = new ArrayList<Carts>();  //用于存储 数据
			List<SessionCart> sessionList = new ArrayList<SessionCart>();
			Goods goods = null;
			SessionCart sessionCart = null;
			Cookie[] cookie = request.getCookies();
			for (Cookie cookie2 : cookie) {
				//把cookie记录导入到cookielist
				if (cookie2.getName().equals("cart")) {
					cookieList = gson.fromJson(cookie2.getValue(), new TypeToken<List<Carts>>(){}.getType());
				}
			}
			org.lanqiao.service.GoodsService gs = new org.lanqiao.service.GoodsServiceImp();
			for (Carts c : cookieList) {
				goods = gs.getBookByGid(c.getBookgid());
				sessionCart = new SessionCart(goods, c.getBookNum());
				sessionList.add(sessionCart);
			}
			request.getSession().setAttribute("sessionList", sessionList);
			request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
		//order
		}else if(type!=null && type.equals("order")){
			request.getRequestDispatcher("/WEB-INF/order.jsp").forward(request, response);
		//orderfinal
		}else if(type!=null && type.equals("orderfinal")){
			request.getRequestDispatcher("/WEB-INF/orderfinal.jsp").forward(request, response);
		//success2
		}else if(type!=null && type.equals("success2")){
			int totalPrice =Integer.parseInt(request.getParameter("totalPrice"));
			String orderid = UUID.randomUUID().toString();
			String userid = null;
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies){
				if(cookie.getName().equals("uname")){
					org.lanqiao.service.UserService us = new org.lanqiao.service.UserServiceImp();
					org.lanqiao.service.PasswordAnswerService pas = new org.lanqiao.service.PasswordAnswerServiceImp();
					Users user = us.getUserByName(cookie.getValue());
					userid = user.getUserid();
				}
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String date = df.format(new Date());// new Date()为获取当前系统时间
			Order order = new Order(orderid, userid, totalPrice, date);
			org.lanqiao.service.OrderService os = new org.lanqiao.service.OrderServiceImp();
			os.insertOrder(order);
			OrderDetail orderDetail = null;
			HttpSession session = request.getSession();
			if (session!=null) {
				List<SessionCart> sessionList = (List<SessionCart>) session.getAttribute("sessionList");
				for (SessionCart s : sessionList) {
					String orderDetailId = UUID.randomUUID().toString();
					orderDetail = new OrderDetail(orderDetailId, s.getGoods().getgTitle(), s.getGoods().getgSaleprice(), s.getNum(), orderid);
					os.insertOrderDetail(orderDetail);
				}
			}
			
			request.getRequestDispatcher("/WEB-INF/success2.jsp").forward(request, response);
		}
		
		else if(type!=null && type.equals("modifyuserinfo")){
			request.getRequestDispatcher("/WEB-INF/modifyuserinfo.jsp").forward(request, response);
		}
		else if(type!=null && type.equals("mail")){
			String userid = request.getParameter("userid");
			String ustateid = request.getParameter("ustateid");
			org.lanqiao.service.UserService userService = new org.lanqiao.service.UserServiceImp();
			userService.insertUstateid(userid, ustateid);
			request.getRequestDispatcher("/WEB-INF/uemail.jsp").forward(request, response);
		}else if(type!=null && type.equals("reg")){
			request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}else if(type!=null && type.equals("registersuccess")){
			request.getRequestDispatcher("/WEB-INF/registersuccess.jsp").forward(request, response);
		}else if(type!=null && type.equals("successful")){
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if(cookie==null){
					break;
				}
				if(cookie.getName().equals("uname")){
					org.lanqiao.service.UserService us = new org.lanqiao.service.UserServiceImp();
					org.lanqiao.service.PasswordAnswerService pas = new org.lanqiao.service.PasswordAnswerServiceImp();
					Users user = us.getUserByName(cookie.getValue());
					PasswordAnswer upasswordAnswer = pas.getPasswordAnswerByUserid(user.getUserid());
					request.getSession().setAttribute("user", user);
					request.getSession().setAttribute("upasswordAnswer", upasswordAnswer);
					request.setAttribute("upasswordAnswer", upasswordAnswer);
					request.setAttribute("user", user);
					request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
					return;
				}
			}
			HttpSession session = request.getSession();
			Object ob = session.getAttribute("user");
			if(ob==null){
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
				
			}
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
