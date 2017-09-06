package org.lanqiao.service;

import org.lanqiao.entity.Books;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;

public class GoodsServiceImp implements GoodsService {
	private org.lanqiao.dao.GoodsDao dao = null;
	public GoodsServiceImp() {
		dao = new org.lanqiao.dao.GoodsDaoImp();
	}
	@Override
	public PageInfo<Goods> goodsList(String cid, int pagesize, int pageindex) {
		return dao.list(cid, pagesize, pageindex);
	}
	@Override
	public Books getBookByCid(String cId) {
		// TODO Auto-generated method stub
		return dao.getBookByCid(cId);
	}
	@Override
	public Goods getBookByGid(String gId) {
		return dao.getBookByGid(gId);
	}
	@Override
	public Goods getBookByGtitle(String gtitle) {
		return dao.getBookByGtitle(gtitle);
	}
	@Override
	public int updatePrice(Goods goods) {
		return dao.updatePrice(goods);
	}
	@Override
	public int deleteGoods(String gid) {
		return dao.deleteGoods(gid);
	}
	

}
