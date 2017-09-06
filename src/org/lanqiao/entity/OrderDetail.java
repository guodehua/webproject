package org.lanqiao.entity;

public class OrderDetail {
	private String orderDetailId;
	private String gtitle;
	private Integer gsalprice;
	private Integer gnumber;
	private String orderid;
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(String orderDetailId, String gtitle, Integer gsalprice, Integer gnumber, String orderid) {
		super();
		this.orderDetailId = orderDetailId;
		this.gtitle = gtitle;
		this.gsalprice = gsalprice;
		this.gnumber = gnumber;
		this.orderid = orderid;
	}
	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getGtitle() {
		return gtitle;
	}
	public void setGtitle(String gtitle) {
		this.gtitle = gtitle;
	}
	public Integer getGsalprice() {
		return gsalprice;
	}
	public void setGsalprice(Integer gsalprice) {
		this.gsalprice = gsalprice;
	}
	public Integer getGnumber() {
		return gnumber;
	}
	public void setGnumber(Integer gnumber) {
		this.gnumber = gnumber;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", gtitle=" + gtitle + ", gsalprice=" + gsalprice
				+ ", gnumber=" + gnumber + ", orderid=" + orderid + "]";
	}
	
}
