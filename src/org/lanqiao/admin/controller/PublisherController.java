package org.lanqiao.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Publisher;

import com.google.gson.Gson;


@WebServlet(name = "publisherController", urlPatterns = { "/publisherController.do" })
public class PublisherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		org.lanqiao.service.PublisherService ps = new org.lanqiao.service.PublisherServiceImp();
		String type = request.getParameter("type");
		if (type!=null&&type.equals("list")) {
			List<Publisher> list = ps.getPublisher();
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(list));	
		}else if (type!=null&&type.equals("add")){
			String pid = request.getParameter("pid");
			String pname = request.getParameter("pname");
			Publisher publisher = new Publisher(pid, pname);
			ps.insertPublisher(publisher);
			response.getWriter().write("1");
		}else if (type!=null&&type.equals("remove")){
			String pid = request.getParameter("pid");
			ps.deletePublisher(pid);
			response.getWriter().write("1");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
