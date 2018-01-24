package com.shop.dao;

import java.util.List;

import com.shop.pojo.User;

public interface UserDao {
	//用户登录
	public User login(String username,String userpass);
	//用户注册
	public int userRegist(User user);
	//查询所有用户
	public List<User> queryUsers();
	//删除用户
	public int deleteUser(int userid);
	//更新会员信息
	public int updateRank(User user);
}
