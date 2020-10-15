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
	 * ͨ����Ʒ���������Ʒ��Ϣ
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
	 * ͨ����Ʒid �����Ʒ����
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
	 * ͨ������ģ����ѯ����������������Ʒ�����б�
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
	 * ͨ����Ʒidɾ����Ʒ��Ϣ
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
	 * ͨ����Ʒ���������Ʒ��Ϣ
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
	 * ͨ����Ʒ��id����Ʒ�ļ۸������Ʒ��Ϣ
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
