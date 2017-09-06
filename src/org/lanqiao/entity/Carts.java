package org.lanqiao.entity;

public class Carts {
	private String bookgid;
	private Integer bookNum;
	public Carts(String bookcid, Integer bookNum) {
		super();
		this.bookgid = bookcid;
		this.bookNum = bookNum;
	}
	public Carts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBookgid() {
		return bookgid;
	}
	public void setBookgid(String bookgid) {
		this.bookgid = bookgid;
	}
	public Integer getBookNum() {
		return bookNum;
	}
	public void setBookNum(Integer bookNum) {
		this.bookNum = bookNum;
	}
	
}
