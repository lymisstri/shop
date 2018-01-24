package com.shop.pojo;

public class Admin {
	private int id;
	private String adminname;
	private String amdinpass;
	public Admin(int id, String adminname, String amdinpass) {
		super();
		this.id = id;
		this.adminname = adminname;
		this.amdinpass = amdinpass;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAmdinpass() {
		return amdinpass;
	}
	public void setAmdinpass(String amdinpass) {
		this.amdinpass = amdinpass;
	}
	
	
}
