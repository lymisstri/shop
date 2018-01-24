package com.shop.dao;

import java.util.List;

import com.shop.pojo.Goods;

public interface GoodDao {
	//��ѯȫ����Ʒ
	public List<Goods> queryAllGood();
	//������Ʒ
	public int addGood(Goods good);
	//ͨ��id������Ʒ
	public Goods queryGoodsById(int goodid);
	//������Ʒ���
	public int updateGoods(Goods good);
	//ģ����ѯ
	public List<Goods> queryByWord(String word);
}
