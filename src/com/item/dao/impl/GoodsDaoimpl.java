package com.item.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.item.beans.Goods;
import com.item.dao.Dao;
import com.item.dao.GoodsDao;

public class GoodsDaoimpl extends Dao<Goods> implements GoodsDao {
	
//	private int getGclassID(String gclass) throws SQLException {
//		String sql = "select id from gclass where name=?";
//		int value = getValue(sql, gclass);
//		return value;
//	}
//	public String getKind(int id) throws SQLException {
//		String sql = "select name from gclass where id=?";
//		String value = getValue(sql, id);
//		return value;
//	}
	/**
	 * 通过物品对象添加物品信息
	 */
	@Override
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		String goodName = goods.getGoodName();
		String price = goods.getPrice();
		String gclassId = goods.getGclassId();
		String miaoshu = goods.getMiaoshu();
		String image = goods.getImage();
		try {
			
			String sql = "insert into goods (name,price,gclass_id,miaoshu,image) value(?,?,?,?,?)";
			update(sql, goodName, price, gclassId,miaoshu,image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 通过物品id 获得物品对象
	 */
	@Override
	public Goods getGood(int id) {
		// TODO Auto-generated method stub
		String sql = "select id goodId,name goodName,price,gclass_id gclassId,image,miaoshu from goods where id=?";

		try {
			return getOne(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 通过名字模糊查询满足名字条件的物品对象列表
	 */
	@Override
	public List<Goods> getGoods(String name) {
		// TODO Auto-generated method stub
		String likeName="%"+name+"%";
		String sql = "select id goodId,name goodName,price,gclass_id gclassId,miaoshu,image from goods where name like ?";
		try {
			return getMore(sql, likeName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 通过物品id删除物品信息
	 */
	@Override
	public void deleteGood(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from goods where id=?";
		try {
			update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 通过物品对象更新物品信息
	 */
	@Override
	public void updateGood(Goods goods) {
		// TODO Auto-generated method stub
		String goodName = goods.getGoodName();
		String price = goods.getPrice();
		int goodId = goods.getGoodId();
		String gclassId2 = goods.getGclassId();
		String sql="update goods set name=?,price=?,gclass_id=? where id=?";
		try {
			update(sql, goodName,price,gclassId2,goodId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 通过物品的id和物品的价格更改物品信息
	 */
	@Override
	public void updatePrice(int id, String price) {
		// TODO Auto-generated method stub
		String sql="update goods set price=? where id=?";
		try {
			update(sql, price,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
