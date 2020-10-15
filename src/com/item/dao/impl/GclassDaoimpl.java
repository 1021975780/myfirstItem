package com.item.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.print.DocFlavor.STRING;

import com.item.beans.Gclass;
import com.item.dao.Dao;
import com.item.dao.GclassDao;

public class GclassDaoimpl extends Dao<Gclass> implements GclassDao {

	/**
	 * 通过名字获得id
	 */
	@Override
	public int getID(String name) {
		// TODO Auto-generated method stub
		String sql = "select id from gclass where name=?";
		try {
			Object value = getValue(sql, name);
			if (value == null) {
				return 0;
			}
			return (int) value;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * //通过id获得类别
	 */
	@Override
	public Gclass getGclass(int id) {
		// TODO Auto-generated method stub
		String sql = "select id gclassId,name from gclass where id=?";
		try {
			return getOne(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得所有类别
	 */
	@Override
	public List<Gclass> getList() {
		// TODO Auto-generated method stub
		String sql = "select id gclassId,name from gclass";
		try {
			return getMore(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过id获得名字
	 */
	@Override
	public String getName(int id) {
		// TODO Auto-generated method stub
		String sql = "select name from gclass where id=?";
		try {
			return getValue(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加类别
	 */
	@Override
	public void addGclass(String name) {
		// TODO Auto-generated method stub
		String sql = "insert into gclass(name) value(?)";
		try {
			update(sql, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 更新类别
	 */
	@Override
	public void updateGclass(Gclass gclass) {
		// TODO Auto-generated method stub
		int gclassId = gclass.getGclassId();
		String name = gclass.getName();
		String sql = "update gclass set name=? where id=?";
		try {
			update(sql, name, gclassId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 模糊查询类别
	 */
	@Override
	public List<Gclass> getList(String likename) {
		// TODO Auto-generated method stub
		String name = "%" + likename + "%";
		String sql = "select id gclassId,name from gclass where name like ?";
		try {
			return getMore(sql, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void removeGclass(int id) {
		// TODO Auto-generated method stub
		String sql="delete from gclass where id=?";
		try {
			update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
