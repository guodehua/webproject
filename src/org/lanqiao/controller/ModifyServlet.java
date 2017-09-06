package org.lanqiao.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.entity.Users;

@WebServlet(name = "modifyServlet", urlPatterns = { "/modify.do" })
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user = (Users) request.getSession().getAttribute("user");
		PasswordAnswer upasswordAnswer = (PasswordAnswer) request.getSession().getAttribute("upasswordAnswer");
		//身份信息
		String upassword = request.getParameter("upassword");
		String usex = request.getParameter("usex");
		String utel = request.getParameter("utel");
		String uaddress = request.getParameter("uaddress");
		user.setUpassword(upassword);
		user.setUtel(utel);
		user.setUsex(usex);
		user.setUaddress(uaddress);
		//密保问题
		String aqustion = request.getParameter("aqustion");
		String answer = request.getParameter("answer");
		String email = request.getParameter("email");
		upasswordAnswer.setAquestion(aqustion);
		upasswordAnswer.setAnswer(answer);
		upasswordAnswer.setAmail(email);
		//把数据写入数据库
		org.lanqiao.service.UserService us = new org.lanqiao.service.UserServiceImp();
		us.insertUsersAgain(user);
		org.lanqiao.service.PasswordAnswerService pas = new org.lanqiao.service.PasswordAnswerServiceImp();
		pas.upDate(upasswordAnswer);
		request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
