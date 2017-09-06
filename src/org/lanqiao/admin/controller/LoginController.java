package org.lanqiao.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Users;

@WebServlet(name = "loginController", urlPatterns = { "/logincontroller.do" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uloginid = request.getParameter("uloginid");
		String password = request.getParameter("password");
		org.lanqiao.service.UserService us = new org.lanqiao.service.UserServiceImp();
		Users users = us.getUserByName(uloginid);
		if (users!=null&&users.getUpassword().equals(password)) {
			response.getWriter().write('1');
		} else {
			response.getWriter().write('0');
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
