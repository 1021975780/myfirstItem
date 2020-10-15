package com.item.dao.impl;

import java.sql.SQLException;

import com.item.beans.Admin;
import com.item.dao.AdminDao;
import com.item.dao.Dao;

public class AdminDaoimpl extends Dao<Admin> implements AdminDao {
	/**
	 * 通过email添加管理员
	 */
	@Override
	public Admin getAdmin(String email) {
		// TODO Auto-generated method stub
		String sql = "select * from admin where email=?";
		Admin admin = null;
		try {
			admin = this.getOne(sql,email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}
	/**
	 * 通过管理员对象更新管理员信息
	 */
	@Override
	public void updateInfo(Admin admin) {
		String email = admin.getEmail();
		String pwd = admin.getPwd();
		String image = admin.getImage();
		String sql="update admin set email=?,pwd=?,image=?";
		try {
			this.update(sql, email,pwd,image);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 通过管理员对象添加管理员
	 */
	@Override
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		String email = admin.getEmail();
		String pwd = admin.getPwd();
		String image = admin.getImage();
		String sql = "insert into admin(email,pwd,image) value(?,?,?)";
		try {
			update(sql, email,pwd,image);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 通过管理员id此删除管理员
	 */
	@Override
	public void removeAdmin(int id) {
		// TODO Auto-generated method stub
		String sql="delete from admin where id=?";
		try {
			update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 通过管理员id重置管理员密码
	 */
	@Override
	public void resetPwd(int id) {
		String sql="update admin set pwd=? where id=?";
		String pwd="123456";
		try {
			update(sql, pwd,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
