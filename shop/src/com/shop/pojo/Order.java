package com.shop.pojo;

public class Order {
	private int id;
	private int orderid;
	private String date;
	private Double totalprice;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, int orderid, String date, Double totalprice) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.date = date;
		this.totalprice = totalprice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	
	
}
