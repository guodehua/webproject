package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Publisher;

public class PublisherServiceImp implements PublisherService {
	org.lanqiao.dao.PublisherDao pd = new org.lanqiao.dao.PublisherDaoImp();
	@Override
	public List<Publisher> getPublisher() {
		return pd.getPublisher();
	}
	@Override
	public void insertPublisher(Publisher publisher) {
		pd.insertPublisher(publisher);
		
	}
	@Override
	public void deletePublisher(String pid) {
		pd.deletePublisher(pid);
		
	}

}
