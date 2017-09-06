package org.lanqiao.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;

import com.google.gson.Gson;

@WebServlet(name = "goodsController", urlPatterns = { "/goodscontroller.do" })
public class GoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//获取分页信息
		org.lanqiao.service.GoodsService gs = new org.lanqiao.service.GoodsServiceImp();
		String cid = request.getParameter("cid");
		int pagesize = Integer.parseInt(request.getParameter("rows"));
		int pageindex = Integer.parseInt(request.getParameter("page"));
		PageInfo<Goods> pageinfo = gs.goodsList(cid, pagesize, pageindex);
		//easy-UI 分页的数据格式要求{total：总记录数,rows：当前页的数据信息}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", pageinfo.getTotalnumber());
		map.put("rows", pageinfo.getData());
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(map));
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
