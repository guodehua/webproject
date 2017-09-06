package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Category;

public class CategoryServiceImp implements CategoryService {

	org.lanqiao.dao.CategoryDao dao = null;
	public CategoryServiceImp() {
		dao = new org.lanqiao.dao.CategoryDaoImp();
	}
	@Override
	public List<Category> categoryList() {
		return dao.list();
	}
	@Override
	public Category get(String cid) {
		// TODO Auto-generated method stub
		return dao.get(cid);
	}


}
