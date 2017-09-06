package org.lanqiao.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Users;


@WebServlet(name = "checkEmailServlet", urlPatterns = { "/checkemail.do" })
public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("uemail");
		//System.out.println("uname--"+uname);
		org.lanqiao.service.UserService us = new org.lanqiao.service.UserServiceImp();
		
		Users user = us.getUserByEmail(uemail);
		if(user!=null){
			response.getWriter().write("1");
		}else{
			response.getWriter().write("0");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
