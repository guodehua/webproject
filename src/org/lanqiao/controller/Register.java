package org.lanqiao.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.entity.Users;
import org.lanqiao.service.PasswordAnswerService;
import org.lanqiao.service.UserService;
import org.lanqiao.service.UserServiceImp;

@WebServlet(name = "register", urlPatterns = { "/register.do" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理注册信息
		//request.setCharacterEncoding("UTF-8");
		Users user = null;
		PasswordAnswer pa = null;
		String userid = UUID.randomUUID().toString();
		String uemail = request.getParameter("uemail");
		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		String usex = request.getParameter("usex");
		String uaddress = request.getParameter("uaddress");
		String utel = request.getParameter("utel");
		String ustateid = "36D0F394FC6A45829385E0BE11208263";//无效用户
		String uroleid = "116F9526C319462780B9CA72F6BB9B41"; //普通用户
		user = new Users(userid, uemail, uname, upassword, usex, uaddress, utel, ustateid, uroleid);
		UserService userDao = new UserServiceImp();
		userDao.regi(user);
		//处理邮箱验证
		String type = request.getParameter("type");
		String content = "点击此链接激活账号：http://localhost:8080/webproject/dispacher.do?type=mail&ustateid=B5868B7A06E54DAEB19658343D3A2B28&userid="+userid;
		//System.out.println("账号内容"+content);
		//org.lanqiao.util.MailUtil.sendMail(uemail, "账号激活", content);;
		//处理验证信息
		String answerid = UUID.randomUUID().toString();
		String aquestion = request.getParameter("aquestion") ;
		String answer = request.getParameter("answer");
		String amail = request.getParameter("amail");
		pa = new PasswordAnswer(answerid, aquestion, answer, amail, userid);
		org.lanqiao.service.PasswordAnswerService pas = new org.lanqiao.service.PasswordAnswerServiceImp();
		pas.insertPasswordAnswer(pa);
		request.getRequestDispatcher("/WEB-INF/registersuccess.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
