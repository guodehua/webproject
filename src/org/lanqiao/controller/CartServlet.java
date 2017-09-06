package org.lanqiao.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Books;
import org.lanqiao.entity.Carts;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.SessionCart;

import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.reflect.TypeToken;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 *1、 添加商品到购物车中
 *2、 购物车中可以进行商品数量的增加和减少 以及 删除商品
 *3、结账后，购物车清空
 */
@WebServlet(name = "cartServlet", urlPatterns = { "/cart.do" })
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new CartServlet().addToCart(request, response);
		//System.out.println(bookcid);
		//1、向购物车中添加商品              商品-->cookie
		
		//2、 购物车中可以进行商品数量的增加和减少 以及 删除商品
		
		//3、结账后，购物车清空
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void addToCart(HttpServletRequest request, HttpServletResponse response){
		//List<Carts> mylist = gson.fromJson(cookie2.getValue(), new TypeToken<List<Carts>>(){}.getType());
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
		String gid = request.getParameter("book");
		//商品是否已经存在
		boolean flg = true;
		for (Carts c : cookieList) {
			if(c.getBookgid().equals(gid)){
				flg = false;
				c.setBookNum(c.getBookNum()+1);
			}
		}
		if (flg) {
			Carts carts = new Carts(gid, 1);
			cookieList.add(carts);
		}
		String json = gson.toJson(cookieList);
		Cookie newCookie = new Cookie("cart", json);
		newCookie.setMaxAge(60*60*24);
		response.addCookie(newCookie);
		org.lanqiao.service.GoodsService gs = new org.lanqiao.service.GoodsServiceImp();
		//添加商品到sessionList
		for (Carts c : cookieList) {
			goods = gs.getBookByGid(c.getBookgid());
			sessionCart = new SessionCart(goods, c.getBookNum());
			sessionList.add(sessionCart);
		}
		request.getSession().setAttribute("sessionList", sessionList);
		try {
			request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
		} catch (ServletException e) {
		} catch (IOException e) {
		}
	}
		
}
