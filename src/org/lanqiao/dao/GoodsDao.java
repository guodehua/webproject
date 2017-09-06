package org.lanqiao.dao;

import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.entity.Books;
public interface GoodsDao {
	public PageInfo<Goods> list(String cid,int pagesize ,int pageindex);
	public int totalRecords(String cid);
	public Books getBookByCid(String cId);
	public Goods getBookByGid(String gId);
	public Goods getBookByGtitle(String gtitle);
	public int updatePrice(Goods goods);
	public int deleteGoods(String gid);
}
