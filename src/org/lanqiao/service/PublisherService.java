package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Publisher;

public interface PublisherService {
	public List<Publisher> getPublisher();
	public void insertPublisher(Publisher publisher);
	public void deletePublisher(String pid);
}
