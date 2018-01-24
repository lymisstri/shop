package com.shop.pojo;

public class Cart {
	private int id;
	private int cartno;
	private int userid;
	private int goodid;
	private int num;
	private int status;
	private Goods good;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int id, int cartno, int userid, int goodid, int num, int status, Goods good) {
		super();
		this.id = id;
		this.cartno = cartno;
		this.userid = userid;
		this.goodid = goodid;
		this.num = num;
		this.status = status;
		this.good = good;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCartno() {
		return cartno;
	}
	public void setCartno(int cartno) {
		this.cartno = cartno;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getGoodid() {
		return goodid;
	}
	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Goods getGood() {
		return good;
	}
	public void setGood(Goods good) {
		this.good = good;
	}
	
}
