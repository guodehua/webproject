package org.lanqiao.service;

import org.lanqiao.entity.Books;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;

public interface GoodsService {
	public PageInfo<Goods> goodsList(String cid,int pagesize,int pageindex);
	public Books getBookByCid(String cId);
	public Goods getBookByGid(String gId);
	public Goods getBookByGtitle(String gtitle);
	public int updatePrice(Goods goods);
	public int deleteGoods(String gid);
}
