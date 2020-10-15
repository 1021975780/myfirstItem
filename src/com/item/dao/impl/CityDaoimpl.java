package com.item.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.item.beans.City;
import com.item.dao.CityDao;
import com.item.utils.JDBCUtils;



public class CityDaoimpl  implements CityDao{
	QueryRunner qr = new QueryRunner();
	/**
	 * 通过省的id获得这个省对应市的信息列表
	 */
	@Override
	public List<City> getList(int id) {
		// TODO Auto-generated method stub
		String sql="select CityID cityId,CityName cityName from city where ProvinceID="+id;
		Connection conn;
		List<City> citys=null;
		try {
			conn = JDBCUtils.getConnection();
			citys = qr.query(conn, sql, new BeanListHandler<>(City.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return citys;
	}

	
}
