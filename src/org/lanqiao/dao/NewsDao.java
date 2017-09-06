package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.News;

public interface NewsDao<T> {
	public List<News> list();
	public News getNews(String id);
}
