package org.lanqiao.entity;

public class Goods {
	private String gId;
	private String gTitle;
	private String gAuthor;
	private Integer gSaleprice;
	private Integer gInprice;
	private String gDesc;
	private String gImg;
	private Integer gClicks;
	private String cId;
	private String pId;
	
	public Goods() {
		super();
	}
	public Goods(String gId, String gTitle, String gAuthor, Integer gSaleprice, Integer gInprice, String gDesc,
			String gImg, Integer gClicks, String cId, String pId) {
		super();
		this.gId = gId;
		this.gTitle = gTitle;
		this.gAuthor = gAuthor;
		this.gSaleprice = gSaleprice;
		this.gInprice = gInprice;
		this.gDesc = gDesc;
		this.gImg = gImg;
		this.gClicks = gClicks;
		this.cId = cId;
		this.pId = pId;
	}
	public String getgId() {
		return gId;
	}
	public void setgId(String gId) {
		this.gId = gId;
	}
	public String getgTitle() {
		return gTitle;
	}
	public void setgTitle(String gTitle) {
		this.gTitle = gTitle;
	}
	public String getgAuthor() {
		return gAuthor;
	}
	public void setgAuthor(String gAuthor) {
		this.gAuthor = gAuthor;
	}
	public Integer getgSaleprice() {
		return gSaleprice;
	}
	public void setgSaleprice(Integer gSaleprice) {
		this.gSaleprice = gSaleprice;
	}
	public Integer getgInprice() {
		return gInprice;
	}
	public void setgInprice(Integer gInprice) {
		this.gInprice = gInprice;
	}
	public String getgDesc() {
		return gDesc;
	}
	public void setgDesc(String gDesc) {
		this.gDesc = gDesc;
	}
	public String getgImg() {
		return gImg;
	}
	public void setgImg(String gImg) {
		this.gImg = gImg;
	}
	public Integer getgClicks() {
		return gClicks;
	}
	public void setgClicks(Integer gClicks) {
		this.gClicks = gClicks;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	@Override
	public String toString() {
		return "Goods [gId=" + gId + ", gTitle=" + gTitle + ", gAuthor=" + gAuthor + ", gSaleprice=" + gSaleprice
				+ ", gInprice=" + gInprice + ", gDesc=" + gDesc + ", gImg=" + gImg + ", gClicks=" + gClicks + ", cId="
				+ cId + ", pId=" + pId + "]";
	}
	
}
