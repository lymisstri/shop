package com.shop.dao;

import java.util.List;

import com.shop.pojo.Goods;

public interface GoodDao {
	//查询全部商品
	public List<Goods> queryAllGood();
	//新增商品
	public int addGood(Goods good);
	//通过id查找商品
	public Goods queryGoodsById(int goodid);
	//更新商品库存
	public int updateGoods(Goods good);
	//模糊查询
	public List<Goods> queryByWord(String word);
}
