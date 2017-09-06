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

import com.google.gson.Gson;

@WebServlet(name = "ajaxPaginatiom", urlPatterns = { "/ajax.do" })
public class AjaxPaginatiom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		org.lanqiao.service.GoodsService gs = new org.lanqiao.service.GoodsServiceImp();
		String pageindex = request.getParameter("pageIndex");
		String pagesize = request.getParameter("pageSize");
		if(pageindex == null){
			pageindex = "1";
		}
		String cid = request.getParameter("cid");
		if(cid == null){
			cid ="1";
		}
		PageInfo<Goods> pageInfo= gs.goodsList(cid, Integer.parseInt(pagesize), Integer.parseInt(pageindex));
		org.lanqiao.service.CategoryService cg = new org.lanqiao.service.CategoryServiceImp();
		Category cate1 = cg.get(cid);
		request.setAttribute("cate1", cate1);
		request.setAttribute("pageInfo", pageInfo);
		//request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(pageInfo));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
