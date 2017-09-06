package org.lanqiao.entity;

public class SessionCart {
	private Goods goods;
	private Integer num;
	public SessionCart() {
	}
	public SessionCart(Goods goods, Integer num) {
		super();
		this.goods = goods;
		this.num = num;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
}
