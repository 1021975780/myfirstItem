package com.item.dao;

import java.sql.SQLException;

import com.item.beans.User;

public class UserDaoimpl extends Dao<User> implements UserDao {

	@Override
	public User getUser(String phone) {
		// TODO Auto-generated method stub
		String sql = "select * from user where phone=?";
		try {
			return getOne(sql, phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
