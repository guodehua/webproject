package org.lanqiao.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.lanqiao.entity.Goods;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchGood
 */
@WebServlet(name = "searchGood", urlPatterns = { "/searchGood.do" })
public class SearchGood extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		org.lanqiao.service.GoodsService gs = new org.lanqiao.service.GoodsServiceImp();
		String type = request.getParameter("type");
		if(type!=null&&type.equals("search")){
			String gtitle = request.getParameter("gtitle");
			Goods goods = gs.getBookByGtitle(gtitle);
			Gson gson = new Gson();
			System.out.println(goods);
			response.getWriter().write(gson.toJson(goods));
			
		}else if(type!=null&&type.equals("updatePrice")){
			String gid = request.getParameter("gid");
			int ginprice = Integer.parseInt(request.getParameter("gInprice"));
			int gsaleprice = Integer.parseInt(request.getParameter("gSaleprice"));
			Goods goods = gs.getBookByGid(gid);
			goods.setgInprice(ginprice);
			goods.setgSaleprice(gsaleprice);
			int a = gs.updatePrice(goods);
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(a));
		}else if(type!=null&&type.equals("delete")){
			String gid = request.getParameter("gid");
			int ss = gs.deleteGoods(gid);
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(ss));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
