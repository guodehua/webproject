package org.lanqiao.admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Users;
import org.lanqiao.service.UserService;
import org.lanqiao.service.UserServiceImp;

import com.google.gson.Gson;


@WebServlet(name = "userServlet", urlPatterns = { "/userservlet.do" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		org.lanqiao.service.UserService us = new org.lanqiao.service.UserServiceImp();
		String type = request.getParameter("type");
		//展示用户信息
		if (type!=null&&type.equals("list")) {
			List<Users> userList = us.userList();
			//System.out.println(userList);
			Gson gson = new Gson();
			String json = gson.toJson(userList);
			response.getWriter().write(json);
		//实现删除功能
		}else if (type!=null&&type.equals("remove")) {
			String userid = request.getParameter("userid");
			boolean boo = us.removeUserByUserid(userid);
			if (boo) {
				response.getWriter().write("1");				
			} else {
				response.getWriter().write("0");
			}
		//添加用户
		}else if (type!=null&&type.equals("add")) {
			String userid = UUID.randomUUID().toString();
			String uemail = request.getParameter("uemail");
			String uname = request.getParameter("uname");
			String upassword = request.getParameter("upassword");
			String usex = request.getParameter("usex");
			String uaddress = request.getParameter("uaddress");
			String utel = request.getParameter("utel");
			String ustateid = "36D0F394FC6A45829385E0BE11208263";//无效用户
			String uroleid = "116F9526C319462780B9CA72F6BB9B41"; //普通用户
			Users user = new Users(userid, uemail, uname, upassword, usex, uaddress, utel, ustateid, uroleid);
			us.regi(user);
			response.getWriter().write("1");
		//更新用户信息
		}else if (type!=null&&type.equals("updata")) {
			String uname = request.getParameter("uname");
			Users users = us.getUserByName(uname);
			users.setUpassword(request.getParameter("upassword"));
			users.setUemail(request.getParameter("uemail"));
			System.out.println(request.getParameter("uemail"));
			users.setUsex(request.getParameter("usex"));
			users.setUtel(request.getParameter("utel"));
			users.setUaddress(request.getParameter("uaddress"));
			us.insertUsersAgain(users);
			response.getWriter().write("1");
		}else if (type!=null&&type.equals("updata")){
			String uname = request.getParameter("uname");
			String ustateid = request.getParameter("ustateid");
			Users users =us.getUserByName(uname);
			users.setUstateid(ustateid);
			us.insertUsersAgain(users);
			response.getWriter().write("1");
		}
			
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
