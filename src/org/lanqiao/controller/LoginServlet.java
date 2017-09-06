package org.lanqiao.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.entity.Users;

@WebServlet(name = "loginServlet", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取cookie记录
//		Cookie[] cookies = request.getCookies();
//		for (Cookie cookie : cookies) {
//			if(cookie.getName().equals("uname")){
//				System.out.println("cook"+cookie.getValue());
//			}
//		}
		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		org.lanqiao.service.UserService us = new org.lanqiao.service.UserServiceImp();
		org.lanqiao.service.PasswordAnswerService pas = new org.lanqiao.service.PasswordAnswerServiceImp();
		Users user = us.getUserByName(uname);
		PasswordAnswer upasswordAnswer = pas.getPasswordAnswerByUserid(user.getUserid());
		//System.out.println(user);
		if(user == null){
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);		
		}else{
			if(user.getUpassword().equals(upassword)){           //登录成功
				if(request.getParameter("chec")!=null){
					Cookie cookie = new Cookie("uname",uname);
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);
				}
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("upasswordAnswer", upasswordAnswer);
				request.setAttribute("upasswordAnswer", upasswordAnswer);
				request.setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
				return;
			}
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
