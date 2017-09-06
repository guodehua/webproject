package org.lanqiao.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.service.*;
/**
 * Servlet implementation class ListServlet
 */
@WebServlet(name = "listservlet", urlPatterns = { "/list.do" })
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		org.lanqiao.service.GoodsService gs = new org.lanqiao.service.GoodsServiceImp();
		String pageindex = request.getParameter("pageindex");
		if(pageindex == null){
			pageindex = "1";
		}
		String cid = request.getParameter("cid");
		if(cid == null){
			cid ="1";
		}
		int pagesize = 5;
		PageInfo<Goods> pageInfo= gs.goodsList(cid, pagesize, Integer.parseInt(pageindex));
		org.lanqiao.service.CategoryService cg = new org.lanqiao.service.CategoryServiceImp();
		Category cate1 = cg.get(cid);
		request.setAttribute("cate1", cate1);
		request.setAttribute("pageInfo", pageInfo);
		request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
