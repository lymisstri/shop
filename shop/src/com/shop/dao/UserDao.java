package com.shop.dao;

import java.util.List;

import com.shop.pojo.User;

public interface UserDao {
	//�û���¼
	public User login(String username,String userpass);
	//�û�ע��
	public int userRegist(User user);
	//��ѯ�����û�
	public List<User> queryUsers();
	//ɾ���û�
	public int deleteUser(int userid);
	//���»�Ա��Ϣ
	public int updateRank(User user);
}
