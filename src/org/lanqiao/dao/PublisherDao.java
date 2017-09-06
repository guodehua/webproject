package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Publisher;

public interface PublisherDao {
	public List<Publisher> getPublisher();
	public void insertPublisher(Publisher publisher);
	public void deletePublisher(String pid);
}
