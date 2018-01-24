package com.shop.pojo;

public class Goods {
	private int id;
	private String goodname;
	private String goodimag;
	private String gooddesc;
	private Double goodpirce;
	private Double goodrprice;
	private int goodnum;
	private int goodsnum;
	
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(int id, String goodname, String goodimag, String gooddesc, Double goodpirce, Double goodrprice,
			int goodnum, int goodsnum) {
		super();
		this.id = id;
		this.goodname = goodname;
		this.goodimag = goodimag;
		this.gooddesc = gooddesc;
		this.goodpirce = goodpirce;
		this.goodrprice = goodrprice;
		this.goodnum = goodnum;
		this.goodsnum = goodsnum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public String getGoodimag() {
		return goodimag;
	}
	public void setGoodimag(String goodimag) {
		this.goodimag = goodimag;
	}
	public String getGooddesc() {
		return gooddesc;
	}
	public void setGooddesc(String gooddesc) {
		this.gooddesc = gooddesc;
	}
	public Double getGoodpirce() {
		return goodpirce;
	}
	public void setGoodpirce(Double goodpirce) {
		this.goodpirce = goodpirce;
	}
	public Double getGoodrprice() {
		return goodrprice;
	}
	public void setGoodrprice(Double goodrprice) {
		this.goodrprice = goodrprice;
	}
	public int getGoodnum() {
		return goodnum;
	}
	public void setGoodnum(int goodnum) {
		this.goodnum = goodnum;
	}
	public int getGoodsnum() {
		return goodsnum;
	}
	public void setGoodsnum(int goodsnum) {
		this.goodsnum = goodsnum;
	}
	
	
	
	
}
