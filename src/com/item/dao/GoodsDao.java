package com.item.dao;

import java.util.List;

import com.item.beans.Goods;

public interface GoodsDao {
	void addGoods(Goods goods);
	List<Goods> getGoods(String name);
	void deleteGood(int id);
	void updateGood(Goods goods);
	Goods getGood(int id);
	void updatePrice(int id,String price);
}
