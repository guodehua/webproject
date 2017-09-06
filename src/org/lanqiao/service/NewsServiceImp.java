package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.News;

public class NewsServiceImp implements NewsService {
	org.lanqiao.dao.NewsDao dao = null;
	
	public NewsServiceImp(){
		dao =new org.lanqiao.dao.NewsDaoImp();
	}
	@Override
	public List<News> newList(){
		return dao.list();
	}
	@Override
	public News getNewsById(String id){
		return dao.getNews(id);
	}
}
